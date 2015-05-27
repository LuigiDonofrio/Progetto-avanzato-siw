package it.uniroma3.model;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.servlet.http.HttpServletRequest;

import org.apache.openejb.server.httpd.HttpSession;

import java.util.List;

@Stateless
public class OrdineFacade {

	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;

	public Ordine createOrdine(String nickname, String code, String prodCode) {


		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();


		/*Ricerca dell'utente, da implementare meglio*/
		List<Utente> users = em.createQuery("select u from Utente u where u.nickname=:username")
				.setParameter("username",nickname).getResultList();
		/*   */

		List<Product> product = em.createQuery("select u from Product u where u.code=:code")
				.setParameter("code",prodCode).getResultList();

		if(request.getSession().getAttribute("ordine")==null){		
			Ordine ordine = new Ordine(code, users.get(0));		


			OrderLine orderline = new OrderLine(product.get(0), 1);
			ordine.addLinea(orderline);
			request.getSession().setAttribute("ordine", ordine);
			return ordine;
		}else{

			Ordine ordine = (Ordine)request.getSession().getAttribute("ordine");
			int qta = 0;
			
			
			for(OrderLine orderline: ordine.getOrderLines()){
				if(orderline.getProdotto().getCode().equals(prodCode)){
					qta = orderline.getQuantita()+1;
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