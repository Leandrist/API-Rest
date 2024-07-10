# Cadastro de Pessoas e Contatos

Este projeto é uma aplicação desenvolvida em Java com SpringBoot, utilizando JPA e Hibernate para persistência de dados. A aplicação permite o cadastro de Pessoas, onde cada pessoa pode ter vários contatos associados.

## Tecnologias Utilizadas

- Java
- SpringBoot
- JPA (Java Persistence API)
- Hibernate
- Banco de dados H2 (em memória)
- Swagger OpenAPI para documentação da API

## Funcionalidades

- Cadastro, consulta, atualização e remoção de Pessoas
- Associação de contatos a cada Pessoa
- Documentação da API disponível via Swagger OpenAPI 

## Como Executar

Para executar o projeto localmente, siga os passos abaixo:

1. Clone o repositório:

   ```bash
   git clone https://github.com/Leandrist/API-Rest.git

2. Navegue até o diretório do projeto:

   cd API-Rest

3. Execute a aplicação utilizando Maven:

   mvn spring-boot:run

4. Acesse a documentação da API:

   Após iniciar a aplicação, acesse a documentação Swagger pelo navegador:

   http://localhost:8585/swagger-ui/index.html


