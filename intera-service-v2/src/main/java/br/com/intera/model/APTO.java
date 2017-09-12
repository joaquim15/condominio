package br.com.intera.model;

import java.io.Serializable;

public class APTO implements Serializable {

	private static final long serialVersionUID = -2302503710399398161L;

	private Long codigoApto;
	private String numeroApto;

	public Long getCodigoApto() {
		return codigoApto;
	}

	public void setCodigoApto(Long codigoApto) {
		this.codigoApto = codigoApto;
	}

	public String getNumeroApto() {
		return numeroApto;
	}

	public void setNumeroApto(String numeroApto) {
		this.numeroApto = numeroApto;
	}

}
