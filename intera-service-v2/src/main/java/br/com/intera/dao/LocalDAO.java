package br.com.intera.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.intera.Exception.BlocoNaoExisteException;
import br.com.intera.factory.ConectionFactory;
import br.com.intera.model.Bloco;
import br.com.intera.model.SalaBloco;
import br.com.intera.util.StringUtils;

/**
 * Serviço REST para locais
 * 
 * @author Joaquim
 *
 */

@Repository
public class LocalDAO implements ILocalDAO {

	Connection con;
	ResultSet rs;
	ConectionFactory factory = new ConectionFactory();
	PreparedStatement pstm = null;
	private Bloco bloco = null;
	private List<SalaBloco> salas = null;

	/**
	 * Lista todos os locais
	 * 
	 * @return List
	 */
	@Override
	public List<Bloco> listaTodos() {

		String query;
		con = factory.getConnection();
		List<Bloco> blocos = new ArrayList<Bloco>();

		try {

			StringBuilder sb = new StringBuilder();

			sb.append(" SELECT ");
			sb.append(" co.nome_condominio AS 'Descricao condominio', ");
			sb.append(" blo.id_bloco AS 'Codigo Bloco', ");
			sb.append(" blo.descricao_bloco AS 'Descricao Bloco' ");
			sb.append(" FROM ");
			sb.append(" bloco blo ");
			sb.append(" LEFT JOIN ");
			sb.append(" condominio co ON (blo.condominio_id = co.id_condominio)");
			sb.append(" ORDER BY blo.id_bloco ");

			query = sb.toString();

			pstm = con.prepareStatement(query);

			this.rs = pstm.executeQuery();

			while (rs.next()) {

				this.bloco = StringUtils.createBloco(this.rs);
				blocos.add(this.bloco);
				bloco = null;
			}

		} catch (Exception e) {
			throw new BlocoNaoExisteException("Bloco nao existe.", e.getCause());
		}

		return blocos;
	}

	@Override
	public List<SalaBloco> buscarPorId(Long id) throws SQLException {

		String query;
		this.con = factory.getConnection();
		SalaBloco sala = null;

		try {

			StringBuilder sb = new StringBuilder();

			sb.append(" SELECT  ");
			sb.append(" bloco.id_bloco as 'Codigo Bloco', ");
			sb.append(" bloco.descricao_bloco as 'Descricao Bloco', ");
			sb.append(" sb.id_sala_bloco as 'Codigo Sala', ");
			sb.append(" sb.descricao_sala_bloco as 'Descricao Sala'");
			sb.append(" FROM ");
			sb.append(" bloco bloco ");
			sb.append(" LEFT JOIN ");
			sb.append(" sala_bloco sb ON (bloco.id_bloco = sb.bloco_sala_id) ");
			sb.append(" WHERE ");
			sb.append(" bloco.id_bloco = ?; ");

			query = sb.toString();

			this.pstm = con.prepareStatement(query);
			this.pstm.setLong(1, id);

			this.rs = pstm.executeQuery();

			salas = new ArrayList<SalaBloco>();

			while (rs.next()) {

				sala = StringUtils.createSala(rs);
				salas.add(sala);
				sala = null;
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (con != null) {
				con.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}
		return salas;
	}

}
