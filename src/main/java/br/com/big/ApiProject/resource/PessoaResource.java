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

import br.com.big.ApiProject.dto.PessoaDTO;
import br.com.big.ApiProject.model.Pessoa;
import br.com.big.ApiProject.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/pessoas") 
public class PessoaResource {
	
	@Autowired
	PessoaService pessoaService;
	
	@Operation(summary = "Retorna todos os registos de Pessoas.")
	@GetMapping //http://localhost:8585/api/pessoas
	public ResponseEntity<List<Pessoa>> findAllPessoas(){
		List<Pessoa> pessoas = pessoaService.findAll();
		if(pessoas == null) {
			return ResponseEntity.notFound().build();
		}
		if(pessoas.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoas);
	}
	
	@Operation(summary = "Retorna o registo de Pessoa por ID.")
	@GetMapping("/{id}")
    public PessoaDTO getPessoaById(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        return pessoa.map(pessoaService::convertToDTO).orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));
    }
	
	@Operation(summary = "Retorna os dados de uma Pessoa por ID para mala direta.")
	@GetMapping("/maladireta/{id}")
    public PessoaDTO getPessoaByIdMalaDireta(@PathVariable Long id) {
        Optional<Pessoa> pessoaOpt = pessoaService.findById(id);
        if (pessoaOpt.isPresent()) {
            Pessoa pessoa = pessoaOpt.get();
            String malaDireta = String.format("%s – CEP: %s – %s/%s",
                    pessoa.getEndereco(), pessoa.getCep(), pessoa.getCidade(), pessoa.getUf());
            return new PessoaDTO(pessoa.getId(), pessoa.getNome(), malaDireta);
        } else {
            throw new IllegalArgumentException("Pessoa não encontrada");
        }
    }
	
	@Operation(summary = "Grava um novo registo de Pessoa.")
	@PostMapping //http://localhost:8585/api/pessoas
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){
		Pessoa newPessoa = pessoaService.save(pessoa);
		if(newPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newPessoa);
	}
	
	@Operation(summary = "Atualiza um registro de Pessoa. Validação por ID.") 
	@PutMapping //http://localhost:8585/api/pessoas
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa){
		Pessoa updPessoa = pessoaService.update(pessoa);
		if(updPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(updPessoa);
	}
	
	@Operation(summary = "Remove um registro de Pessoa por ID.")
	@DeleteMapping("/{id}") //http://localhost:8585/api/pessoas/id
	public ResponseEntity<?> delete(@PathVariable Long id){
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
