package model;

import java.time.LocalDateTime;
import java.util.Date;

public class Tarefa {

	private Long id;
	private Long idCliente;
	private String nome;
	private Date dataInicio;
	private Date dataLimite;
	private String concluida;
	
	public Tarefa() {
		
	}
	
	public Tarefa(Long idCliente, String nome, Date dataInicio, Date dataLimite,
			String concluida) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataLimite = dataLimite;
		this.concluida = concluida;
	}

	public Tarefa(Long id, Long idCliente, String nome, Date dataInicio, Date dataLimite,
			String concluida) {
		this.id = id;
		this.idCliente = idCliente;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataLimite = dataLimite;
		this.concluida = concluida;
	}

	public Long getId() {
		return id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}

	public String getConcluida() {
		return concluida;
	}

	public void setConcluida(String concluida) {
		this.concluida = concluida;
	}
}
