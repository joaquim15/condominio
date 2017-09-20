package br.com.intera.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.intera.Exception.BlocoNaoExisteException;
import br.com.intera.factory.ConectionFactory;
import br.com.intera.model.Bloco;
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

	/**
	 * Lista todos os locais
	 * 
	 * @return List
	 */
	@Override
	public List<Bloco> listaTodos() {

		String query;
		con = factory.getConnection();
		Bloco bloco = null;
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

				bloco = StringUtils.createBloco(this.rs);
				blocos.add(bloco);
				bloco = null;
			}

		} catch (Exception e) {
			throw new BlocoNaoExisteException("Bloco nao existe.", e.getCause());
		}

		return blocos;
	}

}
