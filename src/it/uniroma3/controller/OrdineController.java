package it.uniroma3.controller;

import it.uniroma3.facade.OrdineFacade;
import it.uniroma3.model.Cliente;
import it.uniroma3.model.OrderLine;
import it.uniroma3.model.Ordine;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
public class OrdineController {

	private HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	private HttpSession session = request.getSession();

	@ManagedProperty(value = "#{param.id}")
	private Long id;
	private String code;

	private String productCode;
	private Ordine ordine;
	private List<Ordine> ordini;
	private List<OrderLine> righe;
	private Cliente cliente;
	private Date dataEvasione;
	private boolean valido;

	@EJB
	private OrdineFacade ordineFacade;

	public String ottieniOrdini() {
		this.ordini = ordineFacade.findAllOrdini();
		return "allOrdini";
	}

	public String ottieniOrdiniNonEvasi() {
		this.ordini = ordineFacade.findAllOrdiniNonEvasi();
		return "allOrdiniDaEvadere";
	}

	public String svuotaCarrello() {
		OrdineFacade.createOrdine();
		return "";
	}
	
	public String evadiOrdine() {
		this.ordini = ordineFacade.evadiOrdine(this.id, dataEvasione);
		return "index";
	}

	public String aggiungiProdotto(String productCode) {
		ordineFacade.aggiungiProdotto(productCode);
		return "index";
	}

	public String prendiOrdiniCliente() {
		this.ordini = ordineFacade.getOrdiniCliente();
		return "myOrders";
	}

	public String findOrdine() {
		this.ordine = ordineFacade.getOrdine(id);
		System.out.println("Sono arrivato");
		this.righe = ordineFacade.getRigheOrdine(this.ordine);
		return "Ordine";
	}
	
	public String findOrdineNonEvaso() {
		this.ordine = ordineFacade.getOrdine(id);
		System.out.println("Sono arrivato");
		this.righe = ordineFacade.getRigheOrdine(this.ordine);
		return "OrdineDaEvadere";
	}
	

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}

	public String registraOrdine() {
		ordineFacade.registraOrdine();
		OrdineFacade.createOrdine();
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

	public String getProductCode() {
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

	public Date getDataEvasione() {
		return dataEvasione;
	}

	public void setDataEvasione(Date dataEvasione) {
		this.dataEvasione = dataEvasione;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<OrderLine> getRighe() {
		return righe;
	}

	public void setRighe(List<OrderLine> righeOrdine) {
		this.righe = righeOrdine;
	}

	public boolean isValido() {
		Ordine ordine = (Ordine) this.session.getAttribute("ordine");
		try {
		return (ordine.getOrderLines().size() > 0);
		} catch (Exception e) {
			return false;
		}
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public OrdineFacade getOrdineFacade() {
		return ordineFacade;
	}

	public void setOrdineFacade(OrdineFacade ordineFacade) {
		this.ordineFacade = ordineFacade;
	}

}
