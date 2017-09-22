package br.com.intera.model;

import java.io.Serializable;
/**
 * Classe que representa sala do Bloco.
 * 
 * @author Joaquim
 *
 */
public class SalaBloco implements Serializable {

	private static final long serialVersionUID = 2127177105713757502L;

	private Long id;

	private String descricao;
	private String capacidade;
	private Bloco bloco;

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

	public boolean equals(SalaBloco b) {
		if (super.equals(b) && this.getCapacidade().equals(b.getCapacidade())) {
			return true;
		}

		return false;
	}

	public SalaBloco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalaBloco(Long id, String descricao, String capacidade) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.capacidade = capacidade;
	}
	
	public SalaBloco(Long id, String descricao, String capacidade, Bloco bloco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.capacidade = capacidade;
		this.bloco = bloco;
	}

	public Bloco getBloco() {
		return bloco;
	}

	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}
}
