package br.com.intera.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Apartamento implements Serializable {

	private static final long serialVersionUID = -5706336884061626429L;

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
