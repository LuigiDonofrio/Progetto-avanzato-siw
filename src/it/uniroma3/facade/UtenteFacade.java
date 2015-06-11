package it.uniroma3.facade;

import it.uniroma3.model.Amministratore;
import it.uniroma3.model.Cliente;
import it.uniroma3.model.Utente;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
@Stateless
public class UtenteFacade {

	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;

	public Cliente creaCliente(String nickname, String name, String lastname, String password, String address) {
		Cliente customer = new Cliente(nickname, name, lastname, password, address);
		em.persist(customer);
		return customer;
	}

	public Amministratore creaAmministratore(String nickname, String name, String lastname, String password) {
		Amministratore admin = new Amministratore(nickname, name, lastname, password);
		em.persist(admin);
		return admin;
	}

	public Utente srcUser(String nickname){
		//System.out.println("Arrivo prima");
		System.out.println(em.createQuery("select u from Utente u where u.nickname=:username").toString());
		List<?> users = em.createQuery("select u from Utente u where u.nickname=:username")
				.setParameter("username",nickname).getResultList();
		//System.out.println("Arrivo dopo");
		return (Utente) users.get(0);

	}

	public void getOrdiniCliente(Cliente cliente) {
		List<Cliente> users = em.createQuery("select c from Cliente c where c.nickname=:username")
				.setParameter("username",cliente.getNickname())
				.getResultList();

		System.out.println("Ho eseguito la ricerca");
	}

	public boolean isCurrentUserAdmin() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		Utente currentUser = (Utente) request.getSession().getAttribute(
				"currentUser");
		try{
			return currentUser.isAdmin();
		}catch(Exception e){
			return false;			
		}
	}
}



