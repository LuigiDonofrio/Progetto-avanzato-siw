package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

@Stateless
@NamedQueries({
	@NamedQuery(name = "findCliente", query = "select u from Cliente u where u.nickname=:username and u.password=:password"),
	@NamedQuery(name = "findAmministratore", query = "select u from Amministratore u where u.nickname=:username and u.password=:password")
})
public class LoginFacade {

	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;

	public Login createLogin(String username, String password) {
		Login login = new Login(username, password);
		return login;
	}

	public Utente validateLogin(Login login) {

		List<Cliente> customers = em.createNamedQuery("findCliente")
				.setParameter("username", login.getUsername())
				.setParameter("password", login.getPassword())
				.getResultList();
				
		List<Cliente> admins = em.createNamedQuery("findAmministratore")
				.setParameter("username", login.getUsername())
				.setParameter("password", login.getPassword())
				.getResultList();
		return null;

	}

}
