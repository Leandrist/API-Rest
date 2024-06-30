package br.com.big.ApiProject.model;

import java.util.Objects;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="Pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PESSOA_ID")
    private Long id;
    
    @Column (nullable = false, name = "PESSOA_NOME")
    private String nome;
    
    @Column (nullable = true, name = "PESSOA_ENDEREÇO")
    private String endereco;
    
    @Column (nullable = true, name = "PESSOA_CIDADE")
    private String cidade;
    
    @Column (nullable = true, name = "PESSOA_CEP")
    private String cep;
    
    @Column (nullable = true, name = "PESSOA_UF")
    private String uf;

    //uma pessoa para vários contatos
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contato> contatos;

    public Pessoa() {}

    public Pessoa(Long id, String nome, String endereco, String cidade, String cep, String uf) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    // Métodos para procura de igualdade
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
        Pessoa other = (Pessoa) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "{id = "      + this.id       + ", " +
                "nome ='"    + this.nome     + ", " +
                "endereco='" + this.endereco + ", " +
                "cidade='"   + this.cidade   + ", " +
                "cep="       + this.cep      + ", " +
                "uf='"       + this.uf       + '}';
    }
}

