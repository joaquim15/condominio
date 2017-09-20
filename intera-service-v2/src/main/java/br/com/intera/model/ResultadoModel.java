package br.com.intera.model;

import java.io.Serializable;

/**
 * Classe que representa response dos servicos.
 * 
 * @author Joaquim
 *
 */

public class ResultadoModel implements Serializable{

	private static final long serialVersionUID = -2673295401951870123L;
	
	private int codigo;
	private String mensagem;

	public ResultadoModel() {

	}

	public ResultadoModel(int codigo, String mensagem) {
		super();
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
