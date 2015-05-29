package it.uniroma3.controller;

import java.util.Map;

import it.uniroma3.model.Ordine;

import it.uniroma3.model.UtenteFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class UtenteController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private String nickname;
	private String lastname;
	private String password;
	private String address;
	private Map<String,Ordine> orders;
	
	@EJB
	private UtenteFacade userFacade;
	
	private String creaCliente(){
		userFacade.creaCliente(nickname, name, lastname, password, address);
		return "index";
	}
	private String creaAmministratore(){
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

}
