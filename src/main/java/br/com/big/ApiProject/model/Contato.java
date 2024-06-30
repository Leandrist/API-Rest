package br.com.big.ApiProject.model;


import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "CONTATO_ID")
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "CONTATO_TIPO", nullable = false)
    private TipoContato tipoContato;
    
    @Column (name = "CONTATO_NUMERO")
    private String contato;

    //vários contatos para uma pessoa
    @ManyToOne
    @JoinColumn(name = "PESSOA_ID", referencedColumnName = "PESSOA_ID")
    private Pessoa pessoa;

    public Contato() {}

    public Contato(Long id, TipoContato tipoContato, String contato, Pessoa pessoa) {
        this.id = id;
        this.tipoContato = tipoContato;
        this.contato = contato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contato other = (Contato) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "{id = "          + this.id          + ", " +
                "tipoContato = " + this.tipoContato + ", " +
                "contato = "     + this.contato     + ", " +
                "pessoa = "      + this.pessoa      + "}";
    }
}

	
	

	
	
	

