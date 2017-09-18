package br.com.intera.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Classe que representa uma reserva
 * 
 * @author Joaquim
 *
 */
public class Reserva implements Serializable {

	private static final long serialVersionUID = -8724086511066547364L;

	private Long id;

	private String descricao;

	private Usuario responsavel;

	private Usuario proprietario;

	private Bloco local;

	private SalaCondomio salaCondominio;

	private SalaBloco salaBloco;

	private Date dataHoraInicio;

	private Date dataHoraFim;

	private Long quantidadePessoas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bloco getLocal() {
		return local;
	}

	public void setLocal(Bloco local) {
		this.local = local;
	}

	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Date getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public Long getQuantidadePessoas() {
		return quantidadePessoas;
	}

	public void setQuantidadePessoas(Long quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public Usuario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}

	public SalaCondomio getSalaCondominio() {
		return salaCondominio;
	}

	public void setSalaCondominio(SalaCondomio salaCondominio) {
		this.salaCondominio = salaCondominio;
	}

	public SalaBloco getSalaBloco() {
		return salaBloco;
	}

	public void setSalaBloco(SalaBloco salaBloco) {
		this.salaBloco = salaBloco;
	}

	public Reserva() {
		super();
	}

	@Override
	public String toString() {
		return "Reservas [id=" + id + ", descricao=" + descricao + ", responsavel=" + responsavel + ", proprietario="
				+ proprietario + ", local=" + local + ", salaCondominio=" + salaCondominio + ", salaBloco=" + salaBloco
				+ ", dataHoraInicio=" + dataHoraInicio + ", dataHoraFim=" + dataHoraFim + ", quantidadePessoas="
				+ quantidadePessoas + "]";
	}

}
