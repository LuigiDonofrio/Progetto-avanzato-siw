package it.uniroma3.facade;

import it.uniroma3.model.Cliente;
import it.uniroma3.model.OrderLine;
import it.uniroma3.model.Ordine;
import it.uniroma3.model.Product;
import it.uniroma3.model.Utente;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.List;

@Stateless
public class OrdineFacade {

	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;
	private HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	private HttpSession session = request.getSession();

	public static Ordine createOrdine() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();

		Cliente cliente = (Cliente) session.getAttribute("currentUser");
		Ordine ordine = new Ordine(cliente);
		session.setAttribute("ordine", ordine);
		return ordine;
	}

	public void aggiungiProdotto(String prodCode) {
		Ordine ordine = (Ordine) this.session.getAttribute("ordine");
		if (ordine.getDataApertura() == null)
			ordine.setDataApertura(new Date());
		for (OrderLine orderline : ordine.getOrderLines()) {
			if (orderline.getProdotto().getCode().equals(prodCode)) {
				orderline.setQuantita(orderline.getQuantita() + 1);
				return;
			}
		}
		List<Product> product = em
				.createQuery("select u from Product u where u.code=:code")
				.setParameter("code", prodCode).getResultList();

		OrderLine orderline = new OrderLine(product.get(0), 1);
		orderline.setOrdine(ordine);
		ordine.addLinea(orderline);
	}

	public void registraOrdine() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		Ordine ordine = (Ordine) request.getSession().getAttribute("ordine");
		ordine.setDataChiusura(new Date());
		em.persist(ordine);
	}

	public List<Ordine> getOrdiniCliente() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		Cliente c = (Cliente) request.getSession().getAttribute("currentUser");
		List<Ordine> ordini = em
				.createQuery("select o from Ordine o where o.cliente=:cliente")
				.setParameter("cliente", c).getResultList();
		return ordini;
	}

	public Ordine getOrdine(Long id) {
		Ordine ordine = em.find(Ordine.class, id);
		return ordine;
	}

	public List<OrderLine> getRigheOrdine(Ordine ordine) {
		List<OrderLine> righe = em
				.createQuery("select o from OrderLine o where o.ordine=:ord")
				.setParameter("ord", ordine).getResultList();
		OrderLine riga = (OrderLine) righe.get(0);

		return righe;
	}

	public List<Ordine> findAllOrdini() {
		List<Ordine> ordini = em.createQuery("Select o from Ordine o")
				.getResultList();
		return ordini;
	}

	public List<Ordine> findAllOrdiniNonEvasi() {

		return em
				.createQuery("select o from Ordine o where o.status=:nonevaso")
				.setParameter("nonevaso", 0).getResultList();
	}

	public List<Ordine> evadiOrdine(long id, Date date) {
		Ordine ordine = em.find(Ordine.class, id);

		List<OrderLine> orderlines = this.getRigheOrdine(ordine);

		for (OrderLine orderline : orderlines) {
			Product prod = em.find(Product.class, orderline.getProdotto()
					.getId());
			if (prod.getQuantita() >= orderline.getQuantita()) {
				prod.setQuantita(prod.getQuantita() - orderline.getQuantita());
				em.merge(prod);
			} else {
				// String errore =
				// "E' stato impossibile evadere l'ordine, controlla la quantità";
				// this.session.setAttribute("errQuant", errore);
				return this.findAllOrdiniNonEvasi();
			}
		}

		ordine.setDataEvasione(date);
		ordine.setStatus(1);

		em.merge(ordine);
		return this.findAllOrdiniNonEvasi();
	}

}
