package br.com.intera.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.intera.model.Bloco;


@Service
public interface ILocalService {

	List<Bloco> listaTodos();

}
