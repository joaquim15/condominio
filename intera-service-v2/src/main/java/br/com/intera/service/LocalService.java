package br.com.intera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intera.dao.LocalDAO;
import br.com.intera.model.Bloco;

/**
 * Serviço REST para locais
 * 
 * @author Joaquim
 *
 */
@Service
public class LocalService implements ILocalService {

	@Autowired
	LocalDAO dao = null;

	@Override
	public List<Bloco> listaTodos() {

		if (dao == null) {
			dao = new LocalDAO();
		}
		return dao.listaTodos();
	}
}
