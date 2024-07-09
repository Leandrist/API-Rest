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

import br.com.big.ApiProject.model.Contato;
import br.com.big.ApiProject.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/contatos") //http://localhost:8585/api/contatos
public class ContatoResource {

	@Autowired
	private  ContatoService contatoService;
	
	@Operation(summary = "Retorna todos os registos de Contatos.")
	@GetMapping //http://localhost:8585/api/contatos
	public ResponseEntity<List<Contato>> findAll(){
		List<Contato> contatos = contatoService.findAll();
		if (contatos == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(contatos);
	}
		
	@Operation(summary = "Retorna o registo de Contato por ID.")
	@GetMapping("/{id}") //http://localhost:8585/api/contatos/id
	public ResponseEntity<Optional<Contato>> findbyId(@PathVariable Long id){
		Optional<Contato> findContato = contatoService.findById(id);
		if(findContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(findContato);
	}
	
	@Operation(summary = "Grava um novo registo de Contato.")
	@PostMapping //http://localhost:8585/api/contatos
	public ResponseEntity<Contato> save(@RequestBody Contato contato){
		Contato newContato = contatoService.save(contato);
		if(newContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newContato);
	}
	
	@Operation(summary = "Atualiza um registro de Contato. Validação por ID.")
	@PutMapping //http://localhost:8585/api/contatos
	public ResponseEntity<Contato> update(@RequestBody Contato contato){
		Contato updContato = contatoService.update(contato);
		if(updContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(updContato);
	}
	
	@Operation(summary = "Remove um registro de Contato por ID.")
	@DeleteMapping("/{id}") //http://localhost:8585/api/contatos/id
	public ResponseEntity<?> delete(@PathVariable Long id){
		contatoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
