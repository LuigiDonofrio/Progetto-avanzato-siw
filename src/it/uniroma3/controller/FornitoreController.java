package it.uniroma3.controller;

import it.uniroma3.facade.FornitoreFacade;
import it.uniroma3.model.Fornitore;
import it.uniroma3.model.Product;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
public class FornitoreController {

	@ManagedProperty(value = "#{param.id}")
	private Long id;
	private String name;
	private String lastname;
	private long p_iva;
	private String indirizzo;
	private String email;
	private long telefono;
	private List<Product> prodotti;
	private long id_p;
	private long id_f;
	private Fornitore fornitore;

	private HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	private HttpSession session = request.getSession();
	
	
	@EJB
	private FornitoreFacade fornitoreFacade;

	public String createFornitore() {
		this.fornitore = this.fornitoreFacade.creaFornitore(this.name,
				this.lastname, this.p_iva, this.email, this.indirizzo,
				this.telefono);
		return "riepilogoFornitore";
	}

	public Fornitore getFornitore() {
		return fornitore;
	}

	public void setFornitore(Fornitore fornitore) {
		this.fornitore = fornitore;
	}

	public String addProdotto() {
		Long id_prodottoCorrente=(Long)this.session.getAttribute("idProdottoCorrente");
		this.fornitore = fornitoreFacade.aggiungiProdotto(this.id, id_prodottoCorrente);
		return "riepilogoFornitore";
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public long getP_iva() {
		return p_iva;
	}

	public void setP_iva(long p_iva) {
		this.p_iva = p_iva;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public List<Product> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Product> prodotti) {
		this.prodotti = prodotti;
	}

	public FornitoreFacade getFornitoreFacade() {
		return fornitoreFacade;
	}

	public void setFornitoreFacade(FornitoreFacade fornitoreFacade) {
		this.fornitoreFacade = fornitoreFacade;
	}

	public long getId_p() {
		return id_p;
	}

	public void setId_p(long id_p) {
		this.id_p = id_p;
	}

	public long getId_f() {
		return id_f;
	}

	public void setId_f(long id_f) {
		this.id_f = id_f;
	}
}
