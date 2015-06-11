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

import java.util.List;

@Stateless
public class OrdineFacade {

	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;

	public Ordine createOrdine(String prodCode) {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		Utente currentUser = (Utente) request.getSession().getAttribute(
				"currentUser");

		List<Product> product = em
				.createQuery("select u from Product u where u.code=:code")
				.setParameter("code", prodCode).getResultList();

		if (request.getSession().getAttribute("ordine") == null) {
			Ordine ordine = new Ordine((Cliente) currentUser);
			OrderLine orderline = new OrderLine(product.get(0), 1);
			orderline.setOrdine(ordine);
			ordine.addLinea(orderline);
			request.getSession().setAttribute("ordine", ordine);
			return ordine;
		} else {
			Ordine ordine = (Ordine) request.getSession()
					.getAttribute("ordine");
			int qta = 0;

			for (OrderLine orderline : ordine.getOrderLines()) {
				if (orderline.getProdotto().getCode().equals(prodCode)) {
					qta = orderline.getQuantita() + 1;
					orderline.setQuantita(qta);
					return ordine;
				}
			}

			OrderLine orderline = new OrderLine(product.get(0), 1);
			orderline.setOrdine(ordine);
			ordine.addLinea(orderline);
			request.getSession().setAttribute("ordine", ordine);

			return ordine;
		}
	}

	public void registraOrdine() {
		System.out.println("Sono entrato nella registrazione");
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();	
		em.persist(request.getSession().getAttribute("ordine"));
		
	}

	public List<Ordine> getOrdiniCliente() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();	
		Cliente c = (Cliente) request.getSession().getAttribute("currentUser");
		System.out.println(c.getId());
		List<Ordine> ordini = em.createQuery("select o from Ordine o where o.cliente=:cliente").setParameter("cliente",c).getResultList();
		System.out.println(ordini.toString());
		return ordini;
	}

	public Ordine getOrdine(Long id) {
		Ordine ordine = em.find(Ordine.class, id);
		return ordine;
	}

	public List<OrderLine> getRigheOrdine(Ordine ordine) {
		List<OrderLine> righe = em.createQuery("select o from OrderLine o where o.ordine=:ord").setParameter("ord", ordine).getResultList();
		System.out.println("Dimensione: "+righe.size());
		OrderLine riga= (OrderLine)righe.get(0);
		System.out.println(riga.getProdotto().getName());
		
		return righe;
	}

}
