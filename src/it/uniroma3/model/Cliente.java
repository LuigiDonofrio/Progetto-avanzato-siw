package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Utente {
	
	@Column(nullable = false)
	private String address;
	
	@OneToMany(mappedBy = "cliente")
	private List<Ordine> ordini;

	public Cliente(String nickname, String name, String lastname,
			String password, String address) {
		super(nickname, name, lastname, password);
		this.address = address;
		this.ordini = new ArrayList<Ordine>();
		
	}
	
	public Cliente(){
		super();
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

}
