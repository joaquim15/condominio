package br.com.intera.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.intera.model.Bloco;
import br.com.intera.model.Reserva;
import br.com.intera.model.ResultadoModel;
import br.com.intera.model.SalaBloco;
import br.com.intera.model.Usuario;
import br.com.intera.service.ReservaService;
import br.com.intera.util.StringUtils;

@RestController
@RequestMapping("/api/condominio")
public class ReservaController {

	private Reserva reserva = null;
	private String json = null;
	private Bloco bloco = new Bloco();
	private SalaBloco salaBloco = new SalaBloco();
	private List<Reserva> reservas = null;
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Autowired
	private ReservaService service;

	@GetMapping("/reservas-bloco-lista")
	public String listarReservas() {

		if (StringUtils.isNull(this.reservas) || !StringUtils.isEmpty(this.reservas) ) {

			this.reservas = service.listaTodas();
		}

		if (StringUtils.isNull(this.reservas)) {
			throw new RuntimeException("Não existe reservas.");
		}

		this.json = gson.toJson(this.reservas);
		
		this.reservas = new ArrayList<Reserva>();

		return json.toString();
	}

	@PostMapping("/buscar-reservas-bloco-por-codigo")
	public String buscaPorId(@RequestParam(name = "codigoReserva", required = true) Long codigoReserva)
			throws SQLException {

		this.reserva = null;

		if (StringUtils.isNull(this.reserva)) {
			this.reserva = service.buscaPorId(codigoReserva);
		}

		if (!StringUtils.isNull(this.reserva)) {
			this.json = gson.toJson(this.reserva);
		}
		return json;
	}

	@PostMapping("/adicionar-reserva-bloco")

		public ResultadoModel adicionar(@RequestParam(name = "descricao_bloco", required = true) String descricao_bloco,
										@RequestParam(name = "descricao_sala_bloco", required = true) String descricao_sala_bloco,
										@RequestParam(name = "data_inicio_reserva", required = true) Date data_inicio_reserva,
										@RequestParam(name = "data_fim_reserva", required = true) Date data_fim_reserva,
										@RequestParam(name = "codigo_responsavel", required = true) Long codigo_responsavel,
										@RequestParam(name = "qtd_pessoas", required = true) Long qtd_pessoas,
										@RequestParam(name = "codigo_proprietario", required = true) Long codigo_proprietario, 
										@RequestParam(name = "descricao_festa", required = true) String descricao_festa) throws SQLException {
		Usuario respo = new Usuario();
		Usuario propri = new Usuario();

		if (StringUtils.isNull(this.reserva)) {
			reserva = new Reserva();
		}

		this.bloco.setDescricao(descricao_bloco);
		this.reserva.setLocal(bloco);
		this.salaBloco.setDescricao(descricao_sala_bloco);
		this.reserva.setSalaBloco(salaBloco);
		this.reserva.setDataHoraInicio(data_inicio_reserva);
		this.reserva.setDataHoraFim(data_fim_reserva);
		respo.setCodigo(codigo_responsavel);
		this.reserva.setResponsavel(respo);
		this.reserva.setQuantidadePessoas(qtd_pessoas);
		propri.setCodigo(codigo_proprietario);
		this.reserva.setProprietario(propri);
		this.reserva.setDescricao(descricao_festa);

		ResultadoModel response = service.adicionar(this.reserva);

		this.reserva = null;

		return response;

	}

	@PostMapping("/atualizar-reserva-bloco")
	public ResultadoModel atualizar(@RequestParam(name = "descricao_festa", required = true) String descricao_festa,
			@RequestParam(name = "codido_responsavel", required = true) Long responsavel_festa,
			@RequestParam(name = "data_inicio_reserva", required = true) Date dataInicioReserva,
			@RequestParam(name = "data_fim_reserva", required = true) Date dataFimReserva,
			@RequestParam(name = "descricao_bloco", required = true) String descricao_bloco,
			@RequestParam(name = "descricao_sala_bloco", required = true) String descricao_sala_bloco,
			@RequestParam(name = "qtd_pessoas", required = true) Long qtd_pessoas,
			@RequestParam(name = "codigo_proprietario", required = true) Long proprietario,
			@RequestParam(name = "codigo_reserva", required = true) Long idReserva) throws SQLException {

		Usuario respo = new Usuario();
		Usuario propri = new Usuario();

		if (StringUtils.isNull(this.reserva)) {
			reserva = new Reserva();
		}

		this.reserva.setDescricao(descricao_festa);
		respo.setCodigo(responsavel_festa);
		this.reserva.setResponsavel(respo);
		this.reserva.setDataHoraInicio(dataInicioReserva);
		this.reserva.setDataHoraFim(dataFimReserva);
		this.bloco.setDescricao(descricao_bloco);
		this.reserva.setLocal(bloco);
		this.salaBloco.setDescricao(descricao_sala_bloco);
		this.reserva.setSalaBloco(salaBloco);
		this.reserva.setQuantidadePessoas(qtd_pessoas);
		propri.setCodigo(proprietario);
		this.reserva.setProprietario(propri);
		this.reserva.setId(idReserva);

		ResultadoModel response = service.atualizar(this.reserva);

		this.reserva = null;

		return response;
	}
}
