package it.uniroma3.facade;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.model.Fornitore;
import it.uniroma3.model.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FornitoreFacade {
	
	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;

	public Fornitore creaFornitore(String nome, long p_iva, String email,
			String indirizzo, long telefono) {
		Fornitore fornitore = new Fornitore(p_iva, nome, indirizzo, email, telefono);
		em.persist(fornitore);
		return fornitore;		
	}

	public Fornitore aggiungiProdotto(long id_f, long id_p) {
		Fornitore f = em.find(Fornitore.class, id_f);
		Product p = em.find(Product.class, id_p);
		f.getProdotti().add(p);
		p.getFornitori().add(f);
		em.merge(p);
		em.merge(f);
		return f;
	}
	
	public Fornitore getFornitore(long id_f){
		Fornitore f = em.find(Fornitore.class, id_f);
		return f;

	}
	
	public List<Product> getProdotti(long id_f){
		Fornitore f = em.find(Fornitore.class, id_f);
		List<Product> prods = em.createQuery("select p from Product p join p.fornitori f where f.id=:f_id").setParameter("f_id", f.getId()).getResultList();
		return prods;
	}
	
}
