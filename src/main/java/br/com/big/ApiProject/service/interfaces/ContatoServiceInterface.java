package br.com.big.ApiProject.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.big.ApiProject.model.Contato;

public interface ContatoServiceInterface {

	Contato save(Contato contato);
	
	Optional<Contato> findById(Long id);
	
	List<Contato> findAll();
	
	Contato update(Contato contato);

	void delete(Long id);
	
}
