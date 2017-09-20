package br.com.intera.model;

import java.io.Serializable;
/**
 * Classe que representa dados de acesso ao sistema
 * 
 * @author Joaquim
 *
 */
public class Login implements Serializable {

	private static final long serialVersionUID = 2548878280842057031L;
	
	private Long _codigo;
	private String _login;
	private String _senha;

	public Long get_codigo() {
		return _codigo;
	}

	public void set_codigo(Long _codigo) {
		this._codigo = _codigo;
	}

	public String get_login() {
		return _login;
	}

	public void set_login(String _login) {
		this._login = _login;
	}

	public String get_senha() {
		return _senha;
	}

	public void set_senha(String _senha) {
		this._senha = _senha;
	}

	public Login(String _login, String _senha) {
		this._login = _login;
		this._senha = _senha;
	}

	public Login() {
		super();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_codigo == null) ? 0 : _codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (_codigo == null) {
			if (other._codigo != null)
				return false;
		} else if (!_codigo.equals(other._codigo))
			return false;
		return true;
	}

}
