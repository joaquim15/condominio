package br.com.intera.model;

import java.io.Serializable;

public class Bloco implements Serializable {

	private static final long serialVersionUID = -8238442296903714787L;

	private Long codigoBroco;
	private String Descricao;

	public Bloco() {

	}

	public Bloco(Long codigoBroco, String descricao) {
		super();
		this.codigoBroco = codigoBroco;
		Descricao = descricao;
	}

	public Long getCodigoBroco() {
		return codigoBroco;
	}

	public void setCodigoBroco(Long codigoBroco) {
		this.codigoBroco = codigoBroco;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

}
