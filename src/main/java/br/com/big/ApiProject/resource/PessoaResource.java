package br.com.big.ApiProject.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.big.ApiProject.model.Pessoa;
import br.com.big.ApiProject.service.PessoaService;

@RestController
@RequestMapping("/api/pessoas") //http://localhost:8080/api/pessoas
public class PessoaResource {
	
	@Autowired
	PessoaService pessoaService;
	
	@GetMapping("pessoa") //http://localhost:8080/api/pessoas/pessoa
	public ResponseEntity<Pessoa> getPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setNome("Leandro");
		pessoa.setCep("07080120");
		pessoa.setCidade("São Paulo");
		pessoa.setEndereco("Rua Antonieta, 101");
		pessoa.setUf("SP");
		return ResponseEntity.ok(pessoa);
	}
}
