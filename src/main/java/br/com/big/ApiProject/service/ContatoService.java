package br.com.big.ApiProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.big.ApiProject.model.Contato;
import br.com.big.ApiProject.model.Pessoa;
import br.com.big.ApiProject.repository.ContatoRepository;
import br.com.big.ApiProject.repository.PessoaRepository;
import br.com.big.ApiProject.service.interfaces.ContatoServiceInterface;


@Service
public class ContatoService implements ContatoServiceInterface {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public List<Contato> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Contato> findById() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contato save(Contato contato) {
		if(contato.getPessoa().getId() != null) {
			
			Optional<Pessoa> findPessoa = pessoaRepository.
					findById(contato.getPessoa().getId());			
			if(!findPessoa.isEmpty()) {

				contato.setPessoa(findPessoa.get());
				return contatoRepository.save(contato);
			}else {
				System.out.println("Pessoa não encontrada id: " + 
						contato.getPessoa().getId());
				return null;
			}
			
		}else {
			System.out.println("Pessoa não encontrada!");
			return null;
		}
	}

	@Override
	public Contato update(Contato contato) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	//Regras de validação de número
    private boolean isCelularValido(String numero) {
        // Tem 11 dígitos numéricos?
        return numero.matches("\\d{11}");
    }
    private boolean isTelefoneValido(String numero) {
        // Tem 10 dígitos numéricos?
        return numero.matches("\\d{10}");
    }

}
		
	

