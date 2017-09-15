package br.com.intera.model;

import java.io.Serializable;
import java.util.Calendar;

public class Usuario implements Serializable {

	private static final long serialVersionUID = -9016114679697033920L;

	private Long codigo;

	private String nome;

	private String sobreNome;

	private String email;

	private Calendar dataCadastro;

	private Login login;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public Usuario(Long codigo, String nome, String sobreNome, String email, Calendar dataCadastro, Login login) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.login = login;
	}

	public Usuario() {
		super();
	}

}
