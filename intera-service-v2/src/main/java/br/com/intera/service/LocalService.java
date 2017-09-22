package br.com.intera.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intera.dao.LocalDAO;
import br.com.intera.model.Bloco;
import br.com.intera.model.SalaBloco;

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

	@Override
	public List<SalaBloco> buscarPorId(Long id) throws SQLException {
		
		if (dao == null) {
			dao = new LocalDAO();
		}
		
		return dao.buscarPorId(id);
	}
}
