package it.uniroma3.model;

import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.PersistenceContext;

@Named

public class Login {


    private String username;
    private String password;

   

    public Login(String username, String password) {
		this.username=username;
		this.password=password;
	}

	public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
    
    

}