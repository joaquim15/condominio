package br.com.intera.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import br.com.intera.Exception.LoginInvalido;
import br.com.intera.factory.ConectionFactory;
import br.com.intera.model.Usuario;
import br.com.intera.util.StringUtils;

@Repository
public class LoginDAO implements ILoginDAO {

	Connection con;
	ResultSet rs;
	ConectionFactory factory = new ConectionFactory();
	PreparedStatement pstm = null;

	Usuario response = new Usuario();

	@Override
	public Usuario doLogin(Usuario usu) throws SQLException {

		String query;
		con = factory.getConnection();

		if (usuExists(usu) == false) {
			throw new LoginInvalido(usu);
		}

		else if (passExists(usu) == false) {
			throw new LoginInvalido(usu);
		}

		try {

			StringBuilder sb = new StringBuilder();

			sb.append(" SELECT ");
			sb.append(" usu.id_usuario as codigo, ");
			sb.append(" usu.nome, ");
			sb.append(" usu.sobre_nome, ");
			sb.append(" usu.email, ");
			sb.append(" log.id_login, ");
			sb.append(" log.nome_login, ");
			sb.append(" log.senha_login, ");
			sb.append(" perfil.descricao_perfil ");
			sb.append(" FROM ");
			sb.append(" usuario usu ");
			sb.append(" INNER JOIN ");
			sb.append(" login log ON (usu.id_usuario = log.usuario_id) ");
			sb.append(" INNER JOIN ");
			sb.append(" login_perfil logPerf ON (log.usuario_id = logPerf.id_login) ");
			sb.append(" INNER JOIN ");
			sb.append(" perfil perfil ON (logPerf.id_perfil = perfil.id_perfil) ");
			sb.append(" WHERE ");
			sb.append(" log.nome_login = ? ");
			sb.append(" AND ");
			sb.append(" log.senha_login = ? ");

			query = sb.toString();

			pstm = con.prepareStatement(query);
			pstm.setString(1, usu.getLogin().get_login());
			pstm.setString(2, usu.getLogin().get_senha());

			rs = pstm.executeQuery();

			while (rs.next()) {
				this.response = StringUtils.createUsuario(rs);
			}
			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return response;

	}

	@Override
	public boolean usuExists(Usuario usu) throws SQLException {

		StringBuilder sb = new StringBuilder();
		String query;

		sb.append(" SELECT ");
		sb.append(" lo.nome_login ");
		sb.append(" FROM ");
		sb.append(" login AS lo ");
		sb.append(" WHERE ");
		sb.append(" lo.nome_login = ? ");

		query = sb.toString();

		pstm = con.prepareStatement(query);
		pstm.setString(1, usu.getLogin().get_login());

		rs = pstm.executeQuery();

		while (rs.next()) {
			this.response = StringUtils.verificaUsu(rs);
			if (response.getLogin().get_login() != null) {
				return true;
			}
		}

		return false;
	}

	public boolean passExists(Usuario usu) throws SQLException {

		StringBuilder sb = new StringBuilder();
		String query;

		sb.append(" SELECT ");
		sb.append(" lo.senha_login ");
		sb.append(" FROM ");
		sb.append(" login AS lo ");
		sb.append(" WHERE ");
		sb.append(" lo.senha_login = ? ");

		query = sb.toString();

		pstm = con.prepareStatement(query);
		pstm.setString(1, usu.getLogin().get_senha());

		rs = pstm.executeQuery();

		while (rs.next()) {
			this.response = StringUtils.verificaPass(rs);
			if (response.getLogin().get_login() != null) {
				return true;
			}
		}

		return false;
	}

}
