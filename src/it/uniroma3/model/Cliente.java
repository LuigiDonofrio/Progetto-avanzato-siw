package it.uniroma3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "findCliente", query = "select u from Cliente u where u.nickname=:username and u.password=:password")
public class Cliente extends Utente {

	@Column(nullable = false)
	private String address;

	private String email;

	private Date dataNascita;

	private Date dataRegistrazione;

	private boolean approvato;

	@OneToMany(mappedBy = "cliente")
	private List<Ordine> ordini;

	//da rimuovere
	public Cliente(String nickname, String password, String name,
			String lastname, String address, String email) {
		super(nickname, name, lastname, password);
		this.address = address;
		this.email = email;
		this.dataNascita = new Date();
		this.dataRegistrazione = new Date();
		this.ordini = new ArrayList<Ordine>();
	}
	
	public Cliente(String nickname, String password, String name,
			String lastname, Date dataNascita, String address, String email) {
		super(nickname, name, lastname, password);
		this.address = address;
		this.email = email;
		this.dataNascita = dataNascita;
		this.dataRegistrazione = new Date();
		this.ordini = new ArrayList<Ordine>();
		this.approvato = false;
	}

	public Cliente() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public boolean isApprovato() {
		return approvato;
	}

	public void setApprovato(boolean approvato) {
		this.approvato = approvato;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}

	public void Approva() {
		this.approvato = true;
	}
	
}
