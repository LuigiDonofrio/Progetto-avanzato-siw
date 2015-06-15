package it.uniroma3.controller;

import java.util.Date;
import java.util.List;

import it.uniroma3.facade.UtenteFacade;
import it.uniroma3.model.Cliente;
import it.uniroma3.model.Utente;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class UtenteController {

	private HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	private HttpSession session = request.getSession();

	@ManagedProperty(value = "#{param.id}")
	private Long id;
	private String name;
	private String nickname;
	private String lastname;
	private Date dataNascita;
	private String password;
	private String passwordRep;
	private String proxyPass;
	private String address;
	private String email;
	private boolean adminLogged;
	private boolean userLogged;

	private List<Cliente> listClienti;
	private Cliente cliente;

	@EJB
	private UtenteFacade userFacade;

	public String creaCliente() {
		userFacade.creaCliente(nickname, password, name, lastname, dataNascita,
				address, email);
		return "riepilogoCliente";
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

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
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

	public String getPasswordRep() {
		return passwordRep;
	}

	public void setPasswordRep(String passwordRep) {
		this.passwordRep = passwordRep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UtenteFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UtenteFacade userFacade) {
		this.userFacade = userFacade;
	}

	public List<Cliente> getListClienti() {
		return listClienti;
	}

	public void setListClienti(List<Cliente> listClienti) {
		this.listClienti = listClienti;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String ottieniClienti() {
		this.listClienti = userFacade.getAllClienti();
		return "allClienti";
	}
	
	public String ottieniClientiDaApprovare() {
		this.listClienti = userFacade.getClientiNonApprovati();
		return "allClienti";
	}

	public String findCliente() {
		this.cliente = userFacade.findCliente(id);
		return "anagraficaCliente";
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

	public void supportValidatePassword(FacesContext context,
			UIComponent component, Object value) {
		this.proxyPass = (String) value;
	}

	public void validatePassword(FacesContext context, UIComponent component,
			Object value) {
		String passwordRep = (String) value;

		if (!passwordRep.equals(this.proxyPass)) {
			((UIInput) component).setValid(false);
			FacesMessage msg = new FacesMessage("Le password non coincidono");
			context.addMessage(component.getClientId(context), msg);

		}
	}

}
