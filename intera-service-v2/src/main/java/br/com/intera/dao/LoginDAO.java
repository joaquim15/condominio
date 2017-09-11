package br.com.intera.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import br.com.intera.Exception.LoginInvalido;
import br.com.intera.factory.ConectionFactory;
import br.com.intera.model.Login;
import br.com.intera.model.Usuario;

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

		try {

			StringBuilder sb = new StringBuilder();

			sb.append(" SELECT ");
			sb.append(" usu.id_usuario as codigo, ");
			sb.append(" usu.nome, ");
			sb.append(" usu.sobreNome, ");
			sb.append(" usu.email, ");
			sb.append(" log.usuario_login, ");
			sb.append(" log.senha_login, ");
			sb.append(" perfil.desc_perfil ");
			sb.append(" FROM ");
			sb.append(" usuario usu ");
			sb.append(" INNER JOIN ");
			sb.append(" login log ON (usu.id_usuario = log.usuario_id) ");
			sb.append(" INNER JOIN ");
			sb.append(" login_perfil logPerf ON (log.usuario_id = logPerf.login_id) ");
			sb.append(" INNER JOIN ");
			sb.append(" perfil perfil ON (logPerf.perfil_id = perfil.id_perfil) ");
			sb.append(" WHERE ");
			sb.append(" log.usuario_login = ? ");
			sb.append(" AND ");
			sb.append(" log.senha_login = ? ");

			query = sb.toString();

			pstm = con.prepareStatement(query);
			pstm.setString(1, usu.getLogin().get_login());
			pstm.setString(2, usu.getLogin().get_senha());

			rs = pstm.executeQuery();

			while (rs.next()) {
				this.response = createUsuario(rs);
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

	public Usuario createUsuario(ResultSet rs) throws SQLException {

		Usuario usu = new Usuario();
		usu.setCodigo(rs.getLong("codigo"));
		usu.setNome(rs.getString("nome"));
		usu.setSobreNome(rs.getString("sobreNome"));
		usu.setEmail(rs.getString("email"));
		usu.setUsuario(rs.getString("usuario_login"));
		Login login = new Login();
		login.set_senha(rs.getString("senha_login"));
		usu.setLogin(login);
		return usu;
	}

	public Usuario verificaUsu(ResultSet rs) throws SQLException {

		Usuario usu = new Usuario();
		usu.setUsuario(rs.getString("usuario_login"));

		return usu;
	}

	@Override
	public boolean usuExists(Usuario usu) throws SQLException {

		StringBuilder sb = new StringBuilder();
		String query;

		sb.append(" SELECT ");
		sb.append(" lo.usuario_login ");
		sb.append(" FROM ");
		sb.append(" login AS lo ");
		sb.append(" WHERE ");
		sb.append(" lo.usuario_login = ? ");

		query = sb.toString();

		pstm = con.prepareStatement(query);
		pstm.setString(1, usu.getLogin().get_login());

		rs = pstm.executeQuery();

		while (rs.next()) {
			this.response = verificaUsu(rs);
			if (response.getUsuario() != null) {
				return true;
			}
		}

		return false;
	}

}
