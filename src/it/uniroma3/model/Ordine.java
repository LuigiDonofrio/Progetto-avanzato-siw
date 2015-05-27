package it.uniroma3.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Column;
import javax.persistence.OneToMany;

@Entity
public class Ordine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String code;
	
	@ManyToOne
	private Utente utente;
	
	@OneToMany 
	@JoinColumn(name = "orders_id")
    private List<OrderLine> orderLines;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Ordine(String code, Utente utente) {
		super();
		this.code = code;
		this.utente = utente;
		this.orderLines = new ArrayList<OrderLine>();
	}
	public void addLinea(OrderLine line){
		this.orderLines.add(line);
	}

}
