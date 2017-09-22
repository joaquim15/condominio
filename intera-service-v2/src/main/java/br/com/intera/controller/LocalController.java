package br.com.intera.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.intera.model.Bloco;
import br.com.intera.model.SalaBloco;
import br.com.intera.service.LocalService;
import br.com.intera.util.StringUtils;

@RestController
@RequestMapping("/api/condominio")
public class LocalController {

	private String json = null;
	private Bloco bloco = null;
	private List<Bloco> blocos = null;
	private List<SalaBloco> salas = null;
	private SalaBloco sala = null;
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Autowired
	private LocalService service;

	@GetMapping("/lista-blocos")
	public String listaTodos() {

		if (StringUtils.isNull(this.blocos) || !StringUtils.isEmpty(this.blocos)) {

			this.blocos = service.listaTodos();
		}

		if (StringUtils.isNull(this.blocos)) {
			throw new RuntimeException("Não existe lista.");
		}

		this.json = gson.toJson(this.blocos);

		this.blocos = new ArrayList<Bloco>();

		return json.toString();

	}

	@GetMapping("/{id}/salas")
	public String buscarSalasBlocoId(@PathVariable("id") Long id) throws SQLException {

		if (!StringUtils.isNull(id) || !StringUtils.isEmpty(id)) {

			this.salas = service.buscarPorId(id);
		}

		if (StringUtils.isNull(this.salas)) {
			throw new RuntimeException("Não existe Sala para este Bloco.");
		}

		this.json = gson.toJson(this.salas);

		this.blocos = new ArrayList<Bloco>();

		return json.toString();

	}
}
