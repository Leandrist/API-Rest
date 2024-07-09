package br.com.big.ApiProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.big.ApiProject.model.Pessoa;
import br.com.big.ApiProject.repository.PessoaRepository;
import br.com.big.ApiProject.service.interfaces.PessoaServiceInterface;

@Service
public class PessoaService implements PessoaServiceInterface {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public Pessoa save(Pessoa pessoa) {
		// Valida nome
        if (pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome da pessoa é obrigatório.");
        }

        // Valida CEP
        if (pessoa.getCep() != null && pessoa.getCep().length() < 8) {
            throw new IllegalArgumentException("O CEP deve ter pelo menos 8 caracteres.");
        }
        
        //Valida UF
        if (pessoa.getUf() != null && pessoa.getUf().length() != 2) {
            throw new IllegalArgumentException("A UF deve ter exatamente duas letras.");
        }
        
        try {
			return pessoaRepository.save(pessoa);
		}catch(Exception e) {
			System.out.println("ERR: Erro ao inserir produto!" + 
					pessoa.toString() + ": " + e.getMessage());
			return null;
		}
	}

	//CRUD
	
	@Override
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll(); 
	}
	
	@Override
	public Optional<Pessoa> findById(Long id) {
		return pessoaRepository.findById(id); 
	}
	
	@Override
	public Pessoa update(Pessoa pessoa) {
		Optional<Pessoa> findPessoa = pessoaRepository.findById(pessoa.getId());
		
		if(findPessoa.isPresent()) {
			Pessoa updPessoa = findPessoa.get(); 
			updPessoa.setCep(pessoa.getCep());
			updPessoa.setNome(pessoa.getNome());
			updPessoa.setEndereco(pessoa.getEndereco());
			updPessoa.setUf(pessoa.getUf());
			updPessoa.setCidade(pessoa.getCidade());
			return pessoaRepository.save(updPessoa); 
		}
		return pessoaRepository.save(pessoa);
	}
	
	@Override
	public void delete(Long id) {
		pessoaRepository.deleteById(id);
	}
}
