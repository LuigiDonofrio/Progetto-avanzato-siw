package it.uniroma3.model;

import javax.persistence.Entity;

@Entity
public class Amministratore extends Utente {

	public Amministratore(String nickname, String name, String lastname,
			String password) {
		super(nickname, name, lastname, password);
	}
	
	public Amministratore(){
		super();
	}

}
