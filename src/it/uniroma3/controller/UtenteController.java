package it.uniroma3.controller;

import java.util.Map;

import it.uniroma3.facade.UtenteFacade;
import it.uniroma3.model.Ordine;
import it.uniroma3.model.Utente;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class UtenteController {

	private HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	private HttpSession session = request.getSession();

	private Long id;
	private String name;
	private String nickname;
	private String lastname;
	private String password;
	private String address;
	private Map<String, Ordine> orders;
	private boolean adminLogged;
	private boolean userLogged;

	@EJB
	private UtenteFacade userFacade;

	public String creaCliente() {
		userFacade.creaCliente(nickname, name, lastname, password, address);
		return "index";
	}

	public String creaAmministratore() {
		userFacade.creaAmministratore(nickname, name, lastname, password);
		return "index";
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Map<String, Ordine> getOrders() {
		return orders;
	}

	public void setOrders(Map<String, Ordine> orders) {
		this.orders = orders;
	}

	public UtenteFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UtenteFacade userFacade) {
		this.userFacade = userFacade;
	}

	public boolean isAdminLogged() {
		try {
			Utente user = (Utente) this.session.getAttribute("currentUser");
			return user.isAdmin();
		} catch (Exception e) {
			return false;
		}
	}

	public void setAdminLogged(boolean adminLogged) {
		this.adminLogged = adminLogged;
	}

	public boolean isUserLogged() {
		return (this.session.getAttribute("currentUser") != null);
	}

	public void setUserLogged(boolean userLogged) {
		this.adminLogged = userLogged;
	}

}
