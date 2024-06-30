package br.com.big.ApiProject.service;

import org.springframework.stereotype.Service;

import br.com.big.ApiProject.model.Pessoa;

@Service
public class PessoaService {
	
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
        
        return(pessoa);
	}

}
