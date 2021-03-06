package br.com.intera.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.intera.model.Reserva;
import br.com.intera.model.ResultadoModel;

public interface IReservaDAO {
	
	/**
	 * Lista todas as reservas
	 * 
	 * @return Response
	 */
	List<Reserva> listaTodas();

	/**
	 * Busca a reserva por id
	 * 
	 * @param id
	 * @return Response
	 * @throws SQLException 
	 */
	Reserva buscaPorId(Long id) throws SQLException;

	/**
	 * Adiciona uma nova reserva
	 * 
	 * @param uriInfo
	 * @param reserva
	 * @return Response
	 * @throws SQLException 
	 */
	ResultadoModel adicionar(Reserva reserva) throws SQLException;

	/**
	 * Atualiza uma reserva
	 * 
	 * @param reserva
	 * @return Response
	 * @throws SQLException 
	 */
	ResultadoModel atualizar(Reserva reserva) throws SQLException;

	/**
	 * Deleta uma reserva
	 * 
	 * @param id
	 * @return Response
	 */
	Reserva deleta(Long id);

}
