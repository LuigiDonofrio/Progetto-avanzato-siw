package it.uniroma3.controller;

import java.util.List;

import it.uniroma3.facade.ProductFacade;
import it.uniroma3.model.Fornitore;
import it.uniroma3.model.Product;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
public class ProductController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private Float price;
	private String description;
	private String code;
	private int quantita;
	private Product product;
	private List<Product> products;
	@ManagedProperty(value="#{param.id_f}")
	private String id_f;
	
	private HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	private HttpSession session = request.getSession();
	
	public String getId_f() {
		return id_f;
	}

	public void setId_f(String id_f) {
		this.id_f = id_f;
	}

	private long id_p;
	private Long[] fornitori;
	private List<Fornitore> allFornitori;
	
	public List<Fornitore> getAllFornitori() {
		return allFornitori;
	}

	public void setAllFornitori(List<Fornitore> allFornitori) {
		this.allFornitori = allFornitori;
	}

	public long getId_p() {
		return id_p;
	}

	public void setId_p(long id_p) {
		this.id_p = id_p;
	}

	public Long[] getFornitori() {
		return fornitori;
	}

	public void setFornitori(Long[] fornitori) {
		this.fornitori = fornitori;
	}

	@EJB
	private ProductFacade productFacade;
	
	
	
	public String createProduct() {
		this.product = productFacade.createProduct(name, code, price, quantita, description);
		return "product"; 
	}
	
	public String listProducts() {
		this.products = productFacade.getAllProducts();
		return "catalogo"; 
	}

	public String findProduct() {
		this.product = productFacade.getProduct(id);
		return "product";
	}
	
	public String findProduct(Long id) {
		this.product = productFacade.getProduct(id);
		return "product";
	}

	/*public String findProductbyName() {
		this.products = productFacade.searchProductbyName(this.name);
		return "catalogo";
	}*/
	
	public String aggiungiFornitori() {
		this.allFornitori = productFacade.getAllFornitori();
		System.out.println("Il prodotto e': "+this.id);
		this.session.setAttribute("idProdottoCorrente", this.id);
		return "addFornitore";
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}


