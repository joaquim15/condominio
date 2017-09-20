package br.com.intera.model;

import java.io.Serializable;
/**
 * Classe que representa sala do condominio
 * 
 * @author Joaquim
 *
 */
public class SalaCondominio implements Serializable {

	private static final long serialVersionUID = 4841498118484479914L;

	private Long id;

	private String descricao;

	private String capacidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	public boolean equals(SalaCondominio b) {
		if (super.equals(b) && this.getCapacidade().equals(b.getCapacidade())) {
			return true;
		}

		return false;
	}

}
