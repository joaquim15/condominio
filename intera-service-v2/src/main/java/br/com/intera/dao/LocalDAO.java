package br.com.intera.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import br.com.intera.factory.ConectionFactory;

@Repository
public class LocalDAO implements ILocalDAO {

	Connection con;
	ResultSet rs;
	ConectionFactory factory = new ConectionFactory();
	PreparedStatement pstm = null;

}
