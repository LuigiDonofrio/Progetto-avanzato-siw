package it.uniroma3.controller;

import it.uniroma3.model.Ordine;
import it.uniroma3.model.OrdineFacade;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.core.ApplicationContext;
import org.apache.openejb.server.httpd.HttpSession;

@ManagedBean
public class OrdineController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String code;
	public String getProductCode() {
		return productCode;
	}

	private String productCode; 
	private Ordine ordine;
	private List<Product> products;
	
	@EJB
	private OrdineFacade ordineFacade;
	
	public String createOrdine(String productCodes) {
		this.ordine = ordineFacade.createOrdine("a","CODE",productCodes);
	    return "index"; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProductode() {
		return productCode;
	}

	public void setProductCode(String product) {
		this.productCode = product;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public OrdineFacade getOrdineFacade() {
		return ordineFacade;
	}

	public void setOrdineFacade(OrdineFacade ordineFacade) {
		this.ordineFacade = ordineFacade;
	}
	

}
