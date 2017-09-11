package br.com.intera.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import br.com.intera.model.Usuario;

@Service
public interface ILoginService {
	Usuario doLogin(Usuario usu) throws SQLException;
}
