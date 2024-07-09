package br.com.big.ApiProject.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.big.ApiProject.model.Contato;
import br.com.big.ApiProject.model.Pessoa;
import br.com.big.ApiProject.model.TipoContato;
import br.com.big.ApiProject.repository.ContatoRepository;
import br.com.big.ApiProject.repository.PessoaRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Contato save(Contato contato) {
		validateContato(contato);
		
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


	public Optional<Contato> findById(Long id) {
		return contatoRepository.findById(id); 
	}
	
	public List<Contato> findAll() {
		return contatoRepository.findAll(); 
	}

	public void delete(long id) {
		contatoRepository.deleteById(id);
	}


	public Contato update(Contato contato) {
		validateContato(contato);
		
		Optional<Contato> findContato = contatoRepository.findById(contato.getId());
		
		if(findContato.isPresent()) {
			Contato updContato = findContato.get();
			updContato.setContato(contato.getContato());
			updContato.setPessoa(contato.getPessoa());
			updContato.setTipoContato(contato.getTipoContato());

			return contatoRepository.save(updContato); //UPDATE
		}else {
			//INSERT
			return save(contato);
		}
		
	}
	

    private void validateContato(Contato contato) {
        if (contato.getTipoContato() == null) {
            throw new IllegalArgumentException("TipoContato não pode ser nulo.");
        }

        if (contato.getPessoa() == null) {
            throw new IllegalArgumentException("Pessoa não pode ser nula.");
        }

        if (contato.getContato() == null || contato.getContato().isEmpty()) {
            throw new IllegalArgumentException("Contato não pode ser nulo ou vazio.");
        }

        if (contato.getTipoContato() == TipoContato.Cel && !isCelularValido(contato.getContato())) {
            throw new IllegalArgumentException("Número de celular inválido. Deve conter 11 dígitos numéricos.");
        }

        if (contato.getTipoContato() == TipoContato.Tel && !isTelefoneValido(contato.getContato())) {
            throw new IllegalArgumentException("Número de telefone inválido. Deve conter 10 dígitos numéricos.");
        }
    }

    private boolean isCelularValido(String numero) {
        // Tem 11 dígitos numéricos?
        return numero.matches("\\d{11}");
    }

    private boolean isTelefoneValido(String numero) {
        // Tem 10 dígitos numéricos?
        return numero.matches("\\d{10}");
    }
}
		
	

