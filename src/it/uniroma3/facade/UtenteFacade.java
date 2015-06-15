package it.uniroma3.facade;

import it.uniroma3.model.Amministratore;
import it.uniroma3.model.Cliente;
import it.uniroma3.model.Utente;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UtenteFacade {

	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;

	public Cliente creaCliente(String nickname, String password, String name,
			String lastname, Date dataNascita, String address, String email) {
		Cliente customer = new Cliente(nickname, password, name, lastname,
				dataNascita, address, email);
		em.persist(customer);
		return customer;
	}

	public Amministratore creaAmministratore(String nickname, String name,
			String lastname, String password) {
		Amministratore admin = new Amministratore(nickname, name, lastname,
				password);
		em.persist(admin);
		return admin;
	}

	public Utente srcUser(String nickname) {
		System.out
				.println(em.createQuery(
						"select u from Utente u where u.nickname=:username")
						.toString());
		List<?> users = em
				.createQuery(
						"select u from Utente u where u.nickname=:username")
				.setParameter("username", nickname).getResultList();
		return (Utente) users.get(0);

	}

	public void getOrdiniCliente(Cliente cliente) {
		List<Cliente> users = em
				.createQuery(
						"select c from Cliente c where c.nickname=:username")
				.setParameter("username", cliente.getNickname())
				.getResultList();

		System.out.println("Ho eseguito la ricerca");
	}

	public List<Cliente> getAllClienti() {
		List<Cliente> clienti = em.createQuery("select c From Cliente c")
				.getResultList();
		return clienti;
	}
	
	public List<Cliente> getClientiNonApprovati() {
		List<Cliente> clienti = em.createQuery("select c From Cliente c where c.approvato=false").getResultList();
		return clienti;
	}


	public Cliente findCliente(Long id) {
		return em.find(Cliente.class, id);
	}

	public List<Cliente> ottientiClientiDaApprovare() {
		return em.createQuery("select c from Cliente c where c.approvato=:yes").setParameter("yes", false).getResultList();
	}
}
