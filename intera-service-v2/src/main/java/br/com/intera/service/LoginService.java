package br.com.intera.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intera.dao.LoginDAO;
import br.com.intera.model.Usuario;

@Service
public class LoginService implements ILoginService {

	@Autowired
	private LoginDAO dao;

	@Override
	public Usuario doLogin(Usuario usu) throws SQLException {
		return dao.doLogin(usu);
	}

}
