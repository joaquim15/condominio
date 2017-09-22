package br.com.intera.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import br.com.intera.model.Bloco;
import br.com.intera.model.Login;
import br.com.intera.model.Reserva;
import br.com.intera.model.SalaBloco;
import br.com.intera.model.Usuario;

public class StringUtils {

	public static String formatMessage(String message, Object... parameters) {
		if (message != null && parameters != null) {
			MessageFormat messageFormat = new MessageFormat(message);
			message = messageFormat.format(parameters, new StringBuffer(), null).toString();
		}
		return message;
	}

	public static boolean isNull(Object obj) {
		return obj == null;
	}

	public static boolean isEmpty(Object obj) {
		return obj == "";
	}

	public static Usuario createUsuario(ResultSet rs) throws SQLException {

		Usuario usu = new Usuario();
		usu.setCodigo(rs.getLong("codigo"));
		usu.setNome(rs.getString("nome"));
		usu.setSobreNome(rs.getString("sobre_nome"));
		usu.setEmail(rs.getString("email"));
		Login login = new Login();
		login.set_codigo(rs.getLong("id_login"));
		login.set_login(rs.getString("nome_login"));
		usu.setLogin(login);
		return usu;
	}
	
	public static Usuario verificaUsu(ResultSet rs) throws SQLException {

		Usuario usu = new Usuario();
		Login login = new Login();

		login.set_login(rs.getString("nome_login"));
		usu.setLogin(login);

		return usu;
	}

	public static Usuario verificaPass(ResultSet rs) throws SQLException {

		Usuario usu = new Usuario();
		Login login = new Login();

		login.set_login(rs.getString("senha_login"));
		usu.setLogin(login);

		return usu;
	}

	public static Reserva createReserva(ResultSet rs) throws SQLException {

		Reserva reserva = new Reserva();
		Usuario usu = new Usuario();
		Bloco bloco = new Bloco();
		SalaBloco salaBloco = new SalaBloco();

		reserva.setId(rs.getLong("Codigo reserva"));
		reserva.setDescricao(rs.getString("Descricao Festa"));
		usu.setNome(rs.getString("Responsavel"));
		reserva.setResponsavel(usu);
		bloco.setDescricao(rs.getString("Descricao Local Bloco"));
		reserva.setLocal(bloco);
		reserva.setDataHoraInicio(rs.getDate("Inicio da Reserva"));
		reserva.setDataHoraFim(rs.getDate("Fim da Reserva"));
		reserva.setQuantidadePessoas(rs.getLong("Quantidade Pessoas"));
		salaBloco.setDescricao(rs.getString("Sala do Bloco Reservada"));
		reserva.setSalaBloco(salaBloco);

		return reserva;
	}

	public static Bloco createBloco(ResultSet rs) throws SQLException {

		Bloco bloco = new Bloco();
		
		bloco.setCodigoBloco(rs.getLong("Codigo Bloco"));
		bloco.setDescricao(rs.getString("Descricao Bloco"));
		
		return bloco;
	}
	
	public static SalaBloco createSala(ResultSet rs) throws SQLException {

		Bloco bloco = new Bloco();
		SalaBloco salaBloco = new SalaBloco();
/*		
		bloco.setCodigoBloco(rs.getLong("Codigo Bloco"));
		bloco.setDescricao(rs.getString("Descricao Bloco"));*/
		salaBloco.setId(rs.getLong("Codigo Sala"));
		salaBloco.setDescricao(rs.getString("Descricao Sala"));
	/*	salaBloco.setBloco(bloco);*/

		return salaBloco;
	}
}
