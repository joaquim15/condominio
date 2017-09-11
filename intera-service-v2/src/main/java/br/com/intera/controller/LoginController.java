package br.com.intera.controller;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.intera.model.Login;
import br.com.intera.model.Usuario;
import br.com.intera.service.ILoginService;

@Controller
@RequestMapping("/intera/condominio")
public class LoginController {

	@Autowired
	private ILoginService service;

	@SuppressWarnings("unused")
	@PostMapping(value = "/doLogin")
	public ResponseEntity<Usuario> doLogin(@RequestParam(value = "usuario", required = true) String usuario,
										   @RequestParam(value = "senha", required = true) String senha) throws SQLException {

		Login login = new Login();
		
		login.set_login(usuario);
		login.set_senha(senha);

		Usuario usu = new Usuario();
		
		usu.setLogin(login);

		if (usu != null) {
			Usuario usuResponse = service.doLogin(usu);
			return new ResponseEntity<Usuario>(usuResponse, HttpStatus.OK);
		}
		return null;

	}

}
