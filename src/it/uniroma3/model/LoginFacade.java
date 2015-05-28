package it.uniroma3.model;

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

	public Utente validateLogin(Login login){

		List<Utente> users= em.createQuery(

				"select u from Utente u where u.nickname=:username and u.password=:password")

				.setParameter("username", login.getUsername())

				.setParameter("password", login.getPassword()).getResultList();

				if(users.size()!=0){return users.get(0);}else{return null;
				}
	}

}
