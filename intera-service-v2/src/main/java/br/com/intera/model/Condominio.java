package br.com.intera.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.intera.Exception.CondominioException;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Condominio implements Serializable {

	private static final long serialVersionUID = 3699153646741901752L;

	private String codigoCondominio;
	private String descricaoCondominio;
	
	private final String CODIGO_BRANCO = "Codigo em Branco.";
	private final String CODIGO_NULO = "Codigo esta Nulo.";
	private final String DESCRICAO_BRANCO = "Descricao em Branco.";
	private final String DESCRICAO_NULO = "Descricao esta Nula.";
	
	private List<Usuario> listUsuarios;
	private List<Bloco> listBlocos;
	private List<SalaCondomio> salas;

	public Condominio(String codigoCondominio, String descricaoCondominio) throws CondominioException {
		this.setCodigoCondominio(codigoCondominio);
		this.setDescricaoCondominio(descricaoCondominio);
	}

	public String getCodigoCondominio() {
		return codigoCondominio;
	}

	public String getDescricaoCondominio() {
		return descricaoCondominio;
	}

	public void setCodigoCondominio(String codigoCondominio) throws CondominioException {
		if (codigoCondominio == null)
			throw new CondominioException(CODIGO_NULO);
		else if ("".equals(codigoCondominio.trim()))
			throw new CondominioException(CODIGO_BRANCO);
		this.codigoCondominio = codigoCondominio;//
	}

	public void setDescricaoCondominio(String descricaoCondominio) throws CondominioException {
		if (descricaoCondominio == null)
			throw new CondominioException(DESCRICAO_NULO);
		else if ("".equals(descricaoCondominio.trim()))
			throw new CondominioException(DESCRICAO_BRANCO);
		this.descricaoCondominio = descricaoCondominio;
	}

	public boolean equals(Condominio e) {
		if (this.getCodigoCondominio().equals(e.getCodigoCondominio())
				&& this.getDescricaoCondominio().equals(e.getDescricaoCondominio())) {
			return true;
		} else
			return false;
	}

	public List<Usuario> getListUsuarios() {
		return listUsuarios;
	}

	public void setListUsuarios(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}

	public List<Bloco> getListBlocos() {
		return listBlocos;
	}

	public void setListBlocos(List<Bloco> listBlocos) {
		this.listBlocos = listBlocos;
	}

	public List<SalaCondomio> getSalas() {
		return salas;
	}

	public void setSalas(List<SalaCondomio> salas) {
		this.salas = salas;
	}

	@Override
	public String toString() {
		return "CodigoCondominio=" + codigoCondominio + "\nDescricao=" + descricaoCondominio;
	}
}
