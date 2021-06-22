package model;

public class SubTarefa {

	private Long id;
	private Long idTarefa;
	private String descricao;
	private String concluida;
	
	public SubTarefa() {
		
	}
	
	public SubTarefa(Long idTarefa, String descricao, String concluida) {
		this.idTarefa = idTarefa;
		this.descricao = descricao;
		this.concluida = concluida;
	}
	
	public SubTarefa(Long id, Long idTarefa, String descricao, String concluida) {
		this.id = id;
		this.idTarefa = idTarefa;
		this.descricao = descricao;
		this.concluida = concluida;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public Long getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(Long idTarefa) {
		this.idTarefa = idTarefa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getConcluida() {
		return concluida;
	}

	public void setConcluida(String concluida) {
		this.concluida = concluida;
	}

}
