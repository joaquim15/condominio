package br.com.intera.dao;

import javax.ws.rs.core.Response;

public interface ILocalDAO {

	Response listaTodos();

	Response listaSalasPorLocal();

}
