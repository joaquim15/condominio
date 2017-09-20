package br.com.intera.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intera.dao.ReservaDAO;
import br.com.intera.model.Reserva;
import br.com.intera.model.ResultadoModel;

@Service
public class ReservaService implements IReservaService {

	@Autowired
	ReservaDAO dao;

	@Override
	public List<Reserva> listaTodas() {
		// TODO Auto-generated method stub
		return dao.listaTodas();
	}

	@Override
	public Reserva buscaPorId(Long codigoReserva) throws SQLException {
		// TODO Auto-generated method stub
		return dao.buscaPorId(codigoReserva);
	}

	@Override
	public ResultadoModel adicionar(Reserva reserva) throws SQLException {
		// TODO Auto-generated method stub
		return dao.adicionar(reserva);
	}

	@Override
	public ResultadoModel atualizar(Reserva reserva) throws SQLException {
		// TODO Auto-generated method stub
		return dao.atualizar(reserva);
	}

	@Override
	public Reserva deleta(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
