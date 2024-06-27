package br.com.big.ApiProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.big.ApiProject.model.Contato;
import br.com.big.ApiProject.model.Pessoa;

@SpringBootApplication
public class ApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProjectApplication.class, args);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setNome("Leandro");
		pessoa.setCep("07080120");
		pessoa.setCidade("São Paulo");
		pessoa.setEndereco("Rua Antonieta, 101");
		pessoa.setUf("SP");
		
		System.out.print(pessoa.toString());
		
		Contato contato = new Contato();
		contato.setId(1L);
		contato.setTipoContato(0);
		contato.setContato("119252393944");
		contato.setPessoa(pessoa);
		
		System.out.print(contato.toString());
		
			
	}
	
	

}
