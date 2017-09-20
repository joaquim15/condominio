package br.com.intera.Exception;

import br.com.intera.model.Usuario;
import br.com.intera.util.StringUtils;

public class LoginInvalido extends RuntimeException {

	private static final long serialVersionUID = 3991862754013967146L;

	public LoginInvalido(Usuario login) {
		this("Login e Senha não encontrados.");
	}

	public LoginInvalido(String mensagem, Object... params) {
		super(StringUtils.formatMessage(mensagem, params));
	}

}
