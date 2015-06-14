package it.uniroma3.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	@Column(nullable=false)
	private int status;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy="ordine")
    private List<OrderLine> orderLines;
	
	@Temporal (TemporalType.DATE)
	private Date dataCreazione;
	
	@Temporal (TemporalType.DATE)
	private Date dataPagamento;
	
	@Temporal (TemporalType.DATE)
	private Date dataEvasione;
	
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataEvasione() {
		return dataEvasione;
	}

	public void setDataEvasione(Date dataEvasione) {
		this.dataEvasione = dataEvasione;
	}

}
