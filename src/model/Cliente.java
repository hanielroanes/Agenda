package model;


public class Cliente {
	private Long id;
	private String nome;
	private String tel;
	private String email;
	private String senha;
	
	public Cliente() {
	}


	public Cliente(String nome, String tel, String email, String senha) {
		this.nome = nome;
		this.tel = tel;
		this.email = email;
		this.senha = senha;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
