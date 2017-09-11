package br.com.intera.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import br.com.intera.model.Usuario;

@Repository
public interface ILoginDAO {

	Usuario doLogin(Usuario usu) throws SQLException;
	
	boolean usuExists(Usuario usu) throws SQLException;
}
