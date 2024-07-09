package br.com.big.ApiProject.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.big.ApiProject.model.Pessoa;

public interface PessoaServiceInterface {

    Pessoa save(Pessoa pessoa);
	
	Optional<Pessoa> findById(Long id);
	
	List<Pessoa> findAll();
	
	Pessoa update(Pessoa pessoa);

	void delete(Long id);
}
