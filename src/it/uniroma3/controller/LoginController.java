package it.uniroma3.controller;

import it.uniroma3.facade.LoginFacade;
import it.uniroma3.facade.OrdineFacade;
import it.uniroma3.model.Cliente;
import it.uniroma3.model.Login;
import it.uniroma3.model.Utente;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@SessionScoped
@ManagedBean
public class LoginController {

	private String username;
	private String password;
	private Login login;
	private String message;
	private Boolean isAdmin;
	private Utente user;

	private HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	private HttpSession session = request.getSession();

	@EJB
	private LoginFacade loginFacade;

	public String loginUtente() {
		this.login = loginFacade.createLogin(username, password);

		if (isAdmin)
			user = this.loginFacade.validaLoginAmministratore(this.login);
		else
			user = this.loginFacade.validaLoginCliente(this.login);

		if (user != null) {
				try {
					Cliente cli = (Cliente) user;
					if (!cli.isApprovato()) {
						String errore = ("<div class=\"alert alert-warning\" role=\"alert\"><span class=\"glyphicon glyphicon-exclamation-sign\" aria-hidden=\"true\"></span><span class=\"sr-only\">Errore:</span> Non sei stato ancora approvato: riprova più tardi o contatta un amministratore!</div>");
						this.request.setAttribute("message", errore);
						return null;
					}
				} catch (Exception e) {}
			this.session.setAttribute("currentUser", user);
			this.request.setAttribute("message", null);
		} else {
			String errore = ("<div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-exclamation-sign\" aria-hidden=\"true\"></span><span class=\"sr-only\">Errore:</span> Hai inserito dei dati di login errati: riprova o registrati!</div>");
			this.request.setAttribute("message", errore);
			return null;
		}

		if (!isAdmin)
		OrdineFacade.createOrdine();

		return "index";

	}

	public String logout() {
		this.session.removeAttribute("currentUser");
		this.session.removeAttribute("ordine");
		this.session.removeAttribute("message");
		this.session.removeAttribute("prodottoCorrente");
		return "index";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public LoginFacade getLoginFacade() {
		return loginFacade;
	}

	public void setLoginFacade(LoginFacade loginFacade) {
		this.loginFacade = loginFacade;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
