package br.com.big.ApiProject.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.big.ApiProject.model.Pessoa;
import br.com.big.ApiProject.service.PessoaService;

@RestController
@RequestMapping("/api/pessoas") 
public class PessoaResource {
	
	@Autowired
	PessoaService pessoaService;
	
	//lista todas as pessoas
	@GetMapping //http://localhost:8585/api/pessoas
	public ResponseEntity<List<Pessoa>> findAllPessoas(){
		List<Pessoa> pessoas = pessoaService.findall();
		if(pessoas == null) {
			return ResponseEntity.notFound().build();
		}
		if(pessoas.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoas);
	}
	
	//retorna os dados de uma Pessoa por ID
	@GetMapping("/{id}") //http://localhost:8585/api/pessoas/id
	public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id){
		Optional<Pessoa> pessoa = pessoaService.findById(id);
		if(pessoa.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoa);
	}
	
	//cria uma nova pessoa
	@PostMapping //http://localhost:8585/api/pessoas
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){
		Pessoa newPessoa = pessoaService.save(pessoa);
		if(newPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newPessoa);
	}
	
	//atualiza uma pessoa existente 
	@PutMapping //http://localhost:8585/api/pessoas
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa){
		Pessoa updPessoa = pessoaService.update(pessoa);
		if(updPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(updPessoa);
	}
	
	//remove uma pessoa por ID
	@DeleteMapping("/{id}") //http://localhost:8585/api/pessoas/id
	public ResponseEntity<?> delete(@PathVariable Long id){
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
