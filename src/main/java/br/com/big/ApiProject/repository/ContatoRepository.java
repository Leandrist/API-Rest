package br.com.big.ApiProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.big.ApiProject.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}

