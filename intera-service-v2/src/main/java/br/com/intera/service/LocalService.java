package br.com.intera.service;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intera.dao.LocalDAO;
import br.com.intera.model.Condominio;

/**
 * Serviço REST para locais
 * 
 * @author Joaquim
 *
 */
@Service
public class LocalService implements ILocalService {

	@Autowired
	private LocalDAO dao;

	@Override
	public Response listaTodos() {
		// TODO Auto-generated method stub
		return dao.listaTodos();
	}

	@Override
	public Response listaSalasPorLocal(Condominio local) {
		// TODO Auto-generated method stub
		return null;
	}

}
