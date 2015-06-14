package it.uniroma3.facade;

import it.uniroma3.model.Fornitore;
import it.uniroma3.model.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import java.util.List;

@Stateless
public class ProductFacade {
	
    @PersistenceContext(unitName = "unit-progetto")
    private EntityManager em;
    
	public Product createProduct(String name, String code, Float price, String description) {
		Product product = new Product(name.toLowerCase(), price, description, code);
		em.persist(product);
		return product;
	}
	
	public Product getProduct(Long id) {
	    Product product = em.find(Product.class, id);
		return product;
	}
	
	public List<Product> getAllProducts() {
        CriteriaQuery<Product> cq = em.getCriteriaBuilder().createQuery(Product.class);
        cq.select(cq.from(Product.class));
        List<Product> products = em.createQuery(cq).getResultList();
		return products;
	}

	public void updateProduct(Product product) {
        em.merge(product);
	}
	
    private void deleteProduct(Product product) {
        em.remove(product);
    }

	public void deleteProduct(Long id) {
        Product product = em.find(Product.class, id);
        deleteProduct(product);
	}
	
	
	public List<Product> searchProductbyName(String nome){
		nome = ("%").concat(nome.toLowerCase().concat("%"));
		List<Product> products = em.createQuery("select u from Product u where u.name LIKE:name")		
				.setParameter("name", nome)
				.getResultList();
		return products;
	}
/*
	
		
	    private EntityManager entityManager;
	    private EntityManagerFactory emf;

		public ProductFacade()  {
			emf = Persistence.createEntityManagerFactory("product-unit");
			entityManager = emf.createEntityManager();
		}

		public Product createProduct(String name, String code, Float price, String description) {
			Product product = new Product(name, price, description, code);
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(product);
			tx.commit();
			entityManager.close();
			emf.close();
			return product;
		}
		
		public Product getProduct(Long id) {
		    Product product = entityManager.find(Product.class, id);
			entityManager.close();
			emf.close();
			return product;
		}
		
		public List<Product> getAllProducts() {
	        CriteriaQuery<Product> cq = entityManager.getCriteriaBuilder().createQuery(Product.class);
	        cq.select(cq.from(Product.class));
	        List<Product> products = entityManager.createQuery(cq).getResultList();
			entityManager.close();
			emf.close();
			return products;
		}

		public void updateProduct(Product product) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
	        entityManager.merge(product);
			tx.commit();
			entityManager.close();
			emf.close();	}
		
	    private void deleteProduct(Product product) {
	        entityManager.remove(product);
	    }

		public void deleteProduct(Long id) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
	        Product product = entityManager.find(Product.class, id);
	        deleteProduct(product);
			tx.commit();
			entityManager.close();
			emf.close();	
		}
*/

	public List<Fornitore> getFornitori(long id_p) {
		Product p = em.find(Product.class, id_p);
		List<Fornitore> forns = em.createQuery("select f from Fornitore f join f.prodotti p where p.id=:p_id").setParameter("p_id", p.getId()).getResultList();
		return forns;
	}
}