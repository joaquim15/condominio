package br.com.intera.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.intera.Exception.CondominioException;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SalaCondomio implements Serializable{

	private static final long serialVersionUID = 4841498118484479914L;
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

	public boolean equals(SalaCondomio b) {
		if (super.equals(b) && this.getCapacidade().equals(b.getCapacidade())) {
			return true;
		}

		return false;
	}

}
