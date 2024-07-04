package br.com.big.ApiProject.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.big.ApiProject.model.Contato;

public interface ContatoServiceInterface {
	
	List<Contato> findAll();
	
	Optional<Contato> findById();
	
	void delete(long id);
	
	Contato save(Contato contato);
	
	Contato update(Contato contato);

}
