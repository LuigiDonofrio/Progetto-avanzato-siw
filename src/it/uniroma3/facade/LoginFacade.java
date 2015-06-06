package it.uniroma3.facade;

import it.uniroma3.model.Login;
import it.uniroma3.model.Utente;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LoginFacade {

	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;

	public Login createLogin(String username, String password) {
		Login login = new Login(username, password);
		return login;
	}

	public Utente validaLoginCliente(Login login) {
		
		List<Utente> customers = em.createNamedQuery("findCliente")
				.setParameter("username", login.getUsername())
				.setParameter("password", login.getPassword())
				.getResultList();

		System.out.println("Customers " + customers.size());
		return customers.get(0);

	}

	public Utente validaLoginAmministratore(Login login) {
				
		List<Utente> admins = em.createNamedQuery("findAmministratore")
				.setParameter("username", login.getUsername())
				.setParameter("password", login.getPassword())
				.getResultList();
		
		System.out.println("Admins " + admins.size());
		return admins.get(0);

	}
	
}
