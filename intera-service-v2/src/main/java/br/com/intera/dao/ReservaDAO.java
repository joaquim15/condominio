package br.com.intera.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.intera.Exception.ReservaJaExisteException;
import br.com.intera.factory.ConectionFactory;
import br.com.intera.model.Reserva;
import br.com.intera.model.ResultadoModel;
import br.com.intera.util.StringUtils;

@Repository
public class ReservaDAO implements IReservaDAO {

	Connection con;
	ResultSet result;
	ConectionFactory factory = new ConectionFactory();
	PreparedStatement pstm = null;

	@Override
	public List<Reserva> listaTodas() {

		String query;
		con = factory.getConnection();
		Reserva reserva = null;
		List<Reserva> reservas = new ArrayList<Reserva>();

		try {

			StringBuilder sb = new StringBuilder();

			sb.append(" SELECT ");
			sb.append(" rs.idReserva as 'Codigo reserva', ");
			sb.append(" rs.descricao AS 'Descricao Festa', ");
			sb.append(" res.nome AS 'Responsavel', ");
			sb.append(" blo.descricao_bloco AS 'Descricao Local Bloco', ");
			sb.append(" rs.dataInicioReserva AS 'Inicio da Reserva', ");
			sb.append(" rs.dataFimReserva AS 'Fim da Reserva', ");
			sb.append(" rs.qtdPessoas AS 'Quantidade Pessoas', ");
			sb.append(" CASE ");
			sb.append(" WHEN rs.salaBlocoId = 1 THEN 'Sala de Jogos' ");
			sb.append(" WHEN rs.salaBlocoId = 2 THEN 'Sala de Reuniao' ");
			sb.append(" END AS 'Sala do Bloco Reservada' ");
			sb.append(" FROM ");
			sb.append(" reserva_salas rs ");
			sb.append(" LEFT JOIN ");
			sb.append(" usuario res ON (rs.responsavel_id = res.id_usuario) ");
			sb.append(" LEFT JOIN ");
			sb.append(" usuario_bloco ub ON (rs.responsavel_id = ub.usuario_id) ");
			sb.append(" LEFT JOIN ");
			sb.append(" bloco blo ON (rs.blocoId = blo.id_bloco) ");
			sb.append(" WHERE blo.descricao_bloco IS NOT NULL ");
			sb.append(" ORDER BY rs.idReserva ");

			query = sb.toString();

			pstm = con.prepareStatement(query);

			result = pstm.executeQuery();

			while (result.next()) {

				reserva = StringUtils.createReserva(result);

				if (reserva != null) {
					reservas.add(reserva);
					reserva = null;
				}
			}

			if (result != null) {
				result.close();
			}

			if (pstm != null) {
				pstm.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ReservaJaExisteException(" Não reservas.");
		}

		return reservas;
	}

	@SuppressWarnings("unused")
	@Override
	public Reserva buscaPorId(Long codigoReserva) throws SQLException {

		String query;
		con = factory.getConnection();
		Reserva reserva = null;
		boolean exist;

		try {

			StringBuilder sb = new StringBuilder();

			sb.append(" SELECT ");
			sb.append(" rs.idReserva as 'Codigo reserva', ");
			sb.append(" rs.descricao AS 'Descricao Festa', ");
			sb.append(" res.nome AS 'Responsavel', ");
			sb.append(" blo.descricao_bloco AS 'Descricao Local Bloco', ");
			sb.append(" rs.dataInicioReserva AS 'Inicio da Reserva', ");
			sb.append(" rs.dataFimReserva AS 'Fim da Reserva', ");
			sb.append(" rs.qtdPessoas AS 'Quantidade Pessoas', ");
			sb.append(" CASE ");
			sb.append(" WHEN rs.salaBlocoId = 1 THEN 'Sala de Jogos' ");
			sb.append(" WHEN rs.salaBlocoId = 2 THEN 'Sala de Reuniao' ");
			sb.append(" END AS 'Sala do Bloco Reservada' ");
			sb.append(" FROM ");
			sb.append(" reserva_salas rs ");
			sb.append(" LEFT JOIN ");
			sb.append(" usuario res ON (rs.responsavel_id = res.id_usuario) ");
			sb.append(" LEFT JOIN ");
			sb.append(" usuario_bloco ub ON (rs.responsavel_id = ub.usuario_id) ");
			sb.append(" LEFT JOIN ");
			sb.append(" bloco blo ON (rs.blocoId = blo.id_bloco) ");
			sb.append(" WHERE rs.idReserva = ? ");
			sb.append(" AND blo.descricao_bloco IS NOT NULL ");
			sb.append(" ORDER BY rs.idReserva ");

			query = sb.toString();

			pstm = con.prepareStatement(query);

			pstm.setLong(1, codigoReserva);

			this.result = pstm.executeQuery();

			exist = result.next();

			if (exist) {

				return reserva = StringUtils.createReserva(this.result);
			}

			throw new ReservaJaExisteException("Não existe reserva para este codigo.");

		} catch (Exception e) {
			e.printStackTrace();
			throw new ReservaJaExisteException("Não existe reserva para este codigo.");
		}
	}

	@Override
	public ResultadoModel adicionar(Reserva reserva) throws SQLException {

		String query = null;
		con = factory.getConnection();

		try {

			StringBuilder sb = new StringBuilder();

			sb.append(" INSERT");
			sb.append(" INTO");
			sb.append(" reserva_salas");
			sb.append(" (descricao, responsavel_id, dataInicioReserva, dataFimReserva, blocoId, salaBlocoId, qtdPessoas, proprietario_id)");
			sb.append(" values (?, ?, ?, ?, ?, ?, ?, ?)");

			if (query == null) {
				query = sb.toString();
				System.out.println("String SQL: " + query);
				pstm = con.prepareStatement(query);

				pstm.setString(1, reserva.getDescricao());
				pstm.setLong(2, reserva.getResponsavel().getCodigo());
				pstm.setDate(3, reserva.getDataHoraInicio());
				pstm.setDate(4, reserva.getDataHoraFim());
				pstm.setString(5, reserva.getLocal().getDescricao());
				pstm.setString(6, reserva.getSalaBloco().getDescricao());
				pstm.setLong(7, reserva.getQuantidadePessoas());
				pstm.setLong(8, reserva.getProprietario().getCodigo());

				int response = pstm.executeUpdate();

				if (response == 1) {

					return new ResultadoModel(response, "Registro cadastrado com sucesso!");
				}
			}

		} catch (SQLException e) {
			return new ResultadoModel(0, "Erro ao cadastrar o registro! detalhe:" + e.getMessage());
		} finally {

			if (pstm != null) {
				pstm.close();
			}

			if (con != null) {
				con.close();
			}

		}
		return null;
	}

	@Override
	public ResultadoModel atualizar(Reserva reserva) throws SQLException {

		String query = null;

		con = factory.getConnection();

		try {

			StringBuilder sb = new StringBuilder();

			sb.append(" UPDATE reserva_salas");
			sb.append(" SET descricao = ?,");
				sb.append(" responsavel_id = ?,");
			   	sb.append(" dataInicioReserva = ?,");
			   	sb.append(" dataFimReserva = ?,");
			   	sb.append(" blocoId = ?,");
			   	sb.append(" salaBlocoId = ?,");
			   	sb.append(" qtdPessoas = ?,");
			   	sb.append(" proprietario_id = ?");
			sb.append(" WHERE idReserva = ? ");

			if (query == null) {
				query = sb.toString();
				System.out.println("String SQL: " + query);
				pstm = con.prepareStatement(query);

				pstm.setString(1, reserva.getDescricao());
				pstm.setLong(2, reserva.getResponsavel().getCodigo());
				pstm.setDate(3, reserva.getDataHoraInicio());
				pstm.setDate(4, reserva.getDataHoraFim());
				pstm.setString(5, reserva.getLocal().getDescricao());
				pstm.setString(6, reserva.getSalaBloco().getDescricao());
				pstm.setLong(7, reserva.getQuantidadePessoas());
				pstm.setLong(8, reserva.getProprietario().getCodigo());
				pstm.setLong(9, reserva.getId());

				int response = pstm.executeUpdate();

				if (response == 1) {

					return new ResultadoModel(response, "Registro alterado com sucesso!");
				}
			}

		} finally {

			if (pstm != null) {
				pstm.close();
			}

			if (con != null) {
				con.close();
			}
		}
		return null;
	}

	@Override
	public Reserva deleta(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
