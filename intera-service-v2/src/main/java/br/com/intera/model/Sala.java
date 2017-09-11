package br.com.intera.model;

import br.com.intera.Exception.CondominioException;

public class Sala extends Condominio {

	private static final long serialVersionUID = 342280246734835343L;

	// Mensagens de Erro e Alertas
	private final String CAPACIDADE_INVALIDO = "Capacidade Invalida.";
	private final String CAPACIDADE_BRANCO = "Capacidade em Branco.";
	private final String CAPACIDADE_NULA = "Capacidade esta nula.";

	private String capacidade;

	public Sala(String codigo, String descricao) throws CondominioException {
		super(codigo, descricao);
		// TODO Auto-generated constructor stub
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
