package br.com.intera.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um Bloco de Condominio
 * 
 * @author Joaquim
 *
 */
public class Bloco implements Serializable {

	private static final long serialVersionUID = -8238442296903714787L;

	private Long codigoBloco;
	private String Descricao;
	private Condominio condominio;

	public Bloco() {

	}

	public Bloco(Long codigoBloco, String descricao) {
		super();
		this.codigoBloco = codigoBloco;
		this.Descricao = descricao;
	}

	public Bloco(Long codigoBloco, String descricao, Condominio condominio) {
		super();
		this.codigoBloco = codigoBloco;
		this.Descricao = descricao;
		this.condominio = condominio;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public Long getCodigoBloco() {
		return codigoBloco;
	}

	public void setCodigoBloco(Long codigoBloco) {
		this.codigoBloco = codigoBloco;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

}
