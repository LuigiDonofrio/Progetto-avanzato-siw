package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Fornitore {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private long p_iva;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String indirizzo;

	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private long telefono;
	
	@ManyToMany
	private List<Product> prodotti;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getP_iva() {
		return p_iva;
	}

	public void setP_iva(long p_iva) {
		this.p_iva = p_iva;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public List<Product> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Product> prodotti) {
		this.prodotti = prodotti;
	}

	public Fornitore(){
		
	}
	public Fornitore(long p_iva, String name, String indirizzo, String email,
			long telefono) {
		super();
		this.p_iva = p_iva;
		this.name = name;
		this.indirizzo = indirizzo;
		this.email = email;
		this.telefono = telefono;
		this.prodotti = new ArrayList<Product>();
	}
	
}
