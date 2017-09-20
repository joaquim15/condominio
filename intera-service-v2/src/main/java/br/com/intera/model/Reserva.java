package br.com.intera.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Classe que representa de uma determinada sala do Condominio ou Bloco
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
	private SalaCondominio salaCondominio;
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

	public SalaCondominio getSalaCondominio() {
		return salaCondominio;
	}

	public void setSalaCondominio(SalaCondominio salaCondominio) {
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

	public Reserva(Long id, String descricao, Usuario responsavel, Usuario proprietario, Bloco local,
			SalaCondominio salaCondominio, SalaBloco salaBloco, Date dataHoraInicio, Date dataHoraFim,
			Long quantidadePessoas) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.responsavel = responsavel;
		this.proprietario = proprietario;
		this.local = local;
		this.salaCondominio = salaCondominio;
		this.salaBloco = salaBloco;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.quantidadePessoas = quantidadePessoas;
	}

	@Override
	public String toString() {
		return "Reservas [id=" + id + ", descricao=" + descricao + ", responsavel=" + responsavel + ", proprietario="
				+ proprietario + ", local=" + local + ", salaCondominio=" + salaCondominio + ", salaBloco=" + salaBloco
				+ ", dataHoraInicio=" + dataHoraInicio + ", dataHoraFim=" + dataHoraFim + ", quantidadePessoas="
				+ quantidadePessoas + "]";
	}

}
