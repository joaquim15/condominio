package br.com.intera.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Repository;

import br.com.intera.factory.ConectionFactory;

@Repository
public class LocalDAO implements ILocalDAO {
	
	Connection con;
	ResultSet rs;
	ConectionFactory factory = new ConectionFactory();
	PreparedStatement pstm = null;

	@Override
	public Response listaTodos() {
		
		
		
		return null;
	}

	@Override
	public Response listaSalasPorLocal() {
		// TODO Auto-generated method stub
		return null;
	}

}
