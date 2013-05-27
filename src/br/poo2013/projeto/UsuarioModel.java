package br.poo2013.projeto;

public class UsuarioModel {
	private String login;
	private String senha;
	private long id;
	private int pontos;
	
	public UsuarioModel(String login, String senha){
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getId() {
		return id;
	}

	public int getPontos() {
		return pontos;
	}
	

}
