package br.com.intera.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.intera.model.Login;
import br.com.intera.model.Usuario;
import br.com.intera.service.LoginService;
import br.com.intera.util.StringUtils;

@RestController
@RequestMapping("/api/condominio")
public class LoginController {

	private String json = null;
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Autowired
	private LoginService service;

	@PostMapping(value = "/doLogin")
	public String doLogin(@RequestParam(value = "usuario", required = true) String usuario,
						  @RequestParam(value = "senha", required = true) String senha) throws SQLException {

		Login login = new Login();

		login.set_login(usuario);
		login.set_senha(senha);

		Usuario usu = new Usuario();

		usu.setLogin(login);

		if (usu != null) {

			Usuario usuResponse = service.doLogin(usu);

			if (!StringUtils.isNull(usuResponse)) {
				this.json = gson.toJson(usuResponse).toString();
			}
			usuResponse = new Usuario();

			return json.toString();
		}
		return null;

	}

}
