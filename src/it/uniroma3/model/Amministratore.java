package it.uniroma3.model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findAmministratore", query = "select u from Amministratore u where u.nickname=:username and u.password=:password")
public class Amministratore extends Utente {

	public Amministratore(String nickname, String name, String lastname,
			String password) {
		super(nickname, name, lastname, password);
	}
	
	public Amministratore(){
		super();
	}
	
	public boolean isAdmin(){
		return true;
	}

}
