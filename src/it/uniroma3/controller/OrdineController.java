package it.uniroma3.controller;

import it.uniroma3.facade.OrdineFacade;
import it.uniroma3.model.OrderLine;
import it.uniroma3.model.Ordine;
import it.uniroma3.model.Product;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	private List<Ordine> ordini;
	private List<OrderLine> righe;
	
	public List<OrderLine> getRighe() {
		return righe;
	}

	public void setRighe(List<OrderLine> righeOrdine) {
		this.righe = righeOrdine;
	}

	@EJB
	private OrdineFacade ordineFacade;
	
	
	public String createOrdine(String productCodes) {
		this.ordine = ordineFacade.createOrdine(productCodes);
	    return "index"; 
	}
	
	public String prendiOrdiniCliente(){
		this.ordini = ordineFacade.getOrdiniCliente();
		return "myOrders";
	}
	
	public String findOrdine(){
		this.ordine = ordineFacade.getOrdine(id);
		this.righe = ordineFacade.getRigheOrdine(this.ordine);
		return "Ordine";
	}
	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}

	public void registraOrdine(){
			ordineFacade.registraOrdine();
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



	public OrdineFacade getOrdineFacade() {
		return ordineFacade;
	}

	public void setOrdineFacade(OrdineFacade ordineFacade) {
		this.ordineFacade = ordineFacade;
	}
	

}
