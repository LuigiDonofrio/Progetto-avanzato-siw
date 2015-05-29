package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;


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
		System.out.println("Arrivo prima");
		System.out.println(em.createQuery("select u from Utente u where u.nickname=:username").toString());
		List<Utente> users = em.createQuery("select u from Utente u where u.nickname=:username")
				.setParameter("username",nickname).getResultList();
			System.out.println("Arrivo dopo");
			return users.get(0);

		}
	}



