package br.com.intera.model;

import java.io.Serializable;

import br.com.intera.Exception.CondominioException;

public class Sala implements Serializable{

	private static final long serialVersionUID = 2108303010314015454L;
	
	// Mensagens de Erro e Alertas
	private final String CAPACIDADE_INVALIDO = "Capacidade Invalida.";
	private final String CAPACIDADE_BRANCO = "Capacidade em Branco.";
	private final String CAPACIDADE_NULA = "Capacidade esta nula.";

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

	public void setCapacidade(String capacidade) throws CondominioException {
		if (capacidade == null)
			throw new CondominioException(CAPACIDADE_NULA);
		else if ("".equals(capacidade.trim()))
			throw new CondominioException(CAPACIDADE_BRANCO);
		else if (capacidade.matches("[\\d]+")) {
			this.capacidade = capacidade;
		} else {
			throw new CondominioException(CAPACIDADE_INVALIDO);
		}
	}

	public boolean equals(Sala b) {
		if (super.equals(b) && this.getCapacidade().equals(b.getCapacidade())) {
			return true;
		}

		return false;
	}

}
