package br.com.big.ApiProject.service;

import org.springframework.stereotype.Service;

import br.com.big.ApiProject.model.Contato;
import br.com.big.ApiProject.model.TipoContato;


@Service
public class ContatoService {

	public Contato save(Contato contato) {

        // Valida contatos, se é celular 11 dígitos, se é telefone 10 dígitos
        if (contato.getTipoContato() == TipoContato.Cel) {
            if (!isCelularValido(contato.getContato())) {
                throw new IllegalArgumentException("Número inválido! Exemplo: (11) 123456789. Seu número deve conter 11 dígitos!");
            }
        } else if (contato.getTipoContato() == TipoContato.Tel) {
            if (!isTelefoneValido(contato.getContato())) {
                throw new IllegalArgumentException("Número inválido! Exemplo:(11) 12345678. Seu número deve conter 10 dígitos");
            }
        }
        
        return (contato);

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
		
	

