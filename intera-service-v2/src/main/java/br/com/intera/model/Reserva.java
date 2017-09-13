package br.com.intera.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.intera.deserializer.CalendarDeserializer;

/**
 * Classe que representa uma reserva
 * 
 * @author Joaquim
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Reserva implements Serializable {

	private static final long serialVersionUID = -8724086511066547364L;

	private Long id;

	private String descricao;

	private Usuario responsavel;

	private Usuario proprietario;

	private Condominio local;

	private SalaCondomio salaCondominio;

	private SalaBloco salaBloco;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm", timezone = "GMT-3")
	@JsonDeserialize(using = CalendarDeserializer.class)
	private Calendar dataHoraInicio;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm", timezone = "GMT-3")
	@JsonDeserialize(using = CalendarDeserializer.class)
	private Calendar dataHoraFim;

	private Long quantidadePessoas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Condominio getLocal() {
		return local;
	}

	public void setLocal(Condominio local) {
		this.local = local;
	}

	public Calendar getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Calendar dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Calendar getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(Calendar dataHoraFim) {
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

	public Reserva(Long id, String descricao, Usuario responsavel, Usuario proprietario, Condominio local,
			SalaCondomio salaCondominio, SalaBloco salaBloco, Calendar dataHoraInicio, Calendar dataHoraFim,
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

}
