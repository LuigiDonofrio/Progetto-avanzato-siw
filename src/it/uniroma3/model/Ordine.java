package it.uniroma3.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.OneToMany;

@Entity
public class Ordine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String code;
	
	@ManyToOne
	private Cliente cliente;
	
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

	public Utente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Ordine() {
	}
	
	public Ordine(Cliente cliente) {
		super();
		this.cliente = cliente;
		this.orderLines = new ArrayList<OrderLine>();
	}
	public void addLinea(OrderLine line){
		this.orderLines.add(line);
	}

}
