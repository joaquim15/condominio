package br.com.intera.service;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import br.com.intera.model.Condominio;

@Service
public interface ILocalService {

	public Response listaTodos();

	/**
	 * Lista as salas por local
	 *
	 * @param idLocal
	 * @return Response
	 */
	public Response listaSalasPorLocal(Condominio local);

}
