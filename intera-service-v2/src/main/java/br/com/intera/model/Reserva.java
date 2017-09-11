package br.com.intera.model;

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
 * @author Joaquims
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Reserva {

	public Reserva() {
	}

	private Long id;
	private Condominio local;
	private Sala sala;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm", timezone = "GMT-3")
	@JsonDeserialize(using = CalendarDeserializer.class)
	private Calendar dataHoraInicio;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm", timezone = "GMT-3")
	@JsonDeserialize(using = CalendarDeserializer.class)
	private Calendar dataHoraFim;
	private String responsavel;
	private Boolean cafe;
	private Long quantidadePessoas;
	private String descricao;

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

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
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

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Boolean getCafe() {
		return cafe;
	}

	public void setCafe(Boolean cafe) {
		this.cafe = cafe;
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

	public Reserva(Condominio local, Sala sala, Calendar dataHoraInicio, Calendar dataHoraFim, String responsavel,
			Boolean cafe, Long quantidadePessoas, String descricao) {

		this.local = local;
		this.sala = sala;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.responsavel = responsavel;
		this.cafe = cafe;
		this.quantidadePessoas = quantidadePessoas;
		this.descricao = descricao;
	}

}
