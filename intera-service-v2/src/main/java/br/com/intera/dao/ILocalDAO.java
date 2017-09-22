package br.com.intera.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.intera.model.Bloco;
import br.com.intera.model.SalaBloco;

public interface ILocalDAO {

	List<Bloco> listaTodos() throws SQLException;

	List<SalaBloco> buscarPorId(Long id) throws SQLException;

}
