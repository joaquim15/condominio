package br.com.intera.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.intera.model.Bloco;
import br.com.intera.model.SalaBloco;


@Service
public interface ILocalService {

	List<Bloco> listaTodos();
	
	List<SalaBloco> buscarPorId(Long id) throws SQLException;

}
