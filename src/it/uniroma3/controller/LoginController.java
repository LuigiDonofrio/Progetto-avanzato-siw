package it.uniroma3.controller;

import it.uniroma3.model.Login;
import it.uniroma3.model.LoginFacade;
import it.uniroma3.model.Utente;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@SessionScoped
@ManagedBean
public class LoginController {
	
	private String username;
	private String password;
	private Login login;
	private String message;
	
	@EJB
	private LoginFacade loginFacade;
	

	public String loginUtente(){
		this.login = loginFacade.createLogin(username,password);
		Utente user = this.loginFacade.validateLogin(this.login);
		
		
		if(user!=null){ 	
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
			request.getSession().setAttribute("currentUser", user);
		message="OK!"; }else{ message="False!";}
		return "Validation";
		
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

}
