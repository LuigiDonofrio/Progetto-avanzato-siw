package it.uniroma3.model;

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
			ordine.addLinea(orderline);
			request.getSession().setAttribute("ordine", ordine);

			return ordine;
		}
	}

}
