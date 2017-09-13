package br.com.intera.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.intera.Exception.CondominioException;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Bloco extends Condominio {

	private static final long serialVersionUID = -8238442296903714787L;
	private Long codigoBroco;
	private String Descricao;

	public Bloco(String codigo, String descricao) throws CondominioException {
		super(codigo, descricao);
		// TODO Auto-generated constructor stub
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
