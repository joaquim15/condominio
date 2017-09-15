package br.com.intera.model;

import java.io.Serializable;
import java.util.List;

import br.com.intera.Exception.CondominioException;

public class Condominio implements Serializable {

	private static final long serialVersionUID = 3699153646741901752L;

	private Long codigoCondominio;
	private String descricaoCondominio;

	private List<Usuario> listUsuarios;
	private List<Bloco> listBlocos;
	private List<SalaCondomio> salas;

	public Condominio(Long codigoCondominio, String descricaoCondominio) throws CondominioException {
		this.setCodigoCondominio(codigoCondominio);
		this.setDescricaoCondominio(descricaoCondominio);
	}

	public Long getCodigoCondominio() {
		return codigoCondominio;
	}

	public String getDescricaoCondominio() {
		return descricaoCondominio;
	}

	public void setCodigoCondominio(Long codigoCondominio) {
		this.codigoCondominio = codigoCondominio;
	}

	public void setDescricaoCondominio(String descricaoCondominio) {
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

	public Condominio() {
		super();
		// TODO Auto-generated constructor stub
	}

}
