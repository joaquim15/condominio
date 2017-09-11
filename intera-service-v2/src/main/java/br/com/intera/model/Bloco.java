package br.com.intera.model;

import br.com.intera.Exception.CondominioException;

public class Bloco extends Condominio {

	private static final long serialVersionUID = -553187676398834235L;

	private Long codigoBroco;
	private String Descricao;

	public Bloco(String codigo, String descricao) throws CondominioException {
		super(codigo, descricao);
		// TODO Auto-generated constructor stub
	}



}
