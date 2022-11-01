# Trabalho para a disciplina Projeto de Sistemas da Informação - Instituto Federal do Ceará

# Contabilidade Fácil
----------------------Inserir descrição do projeto----------------------

## Tecnologias utilizadas

- **[Spring Boot](https://spring.io/projects/spring-boot)**
- **[Spring Data JPA](https://spring.io/projects/spring-data-jpa#overview)** 
- **[Hibernate](https://hibernate.org/orm/)**
- **[Lombok](https://projectlombok.org/)**
- **[Docker](https://www.docker.com/)**
- **[PostgreSQL](https://www.postgresql.org/)**
- **[Swagger](https://swagger.io/)**

# Executando o projeto em nuvem
Backend: https://contabilidade-facil-api.herokuapp.com/ <br/>
Frontend: Em desenvolvimento...

# Executando o projeto localmente
## Requisitos
- [Git](https://git-scm.com/)
- [Docker](https://www.docker.com/)
- [JDK 11+](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
- IDE de sua preferência ([Eclipse / Spring Tools Suite](https://spring.io/tools), [IntelliJ](https://www.jetbrains.com/pt-br/idea/download/#section=windows), etc)

## Como executar o projeto
- Em um diretório de sua preferência, abra o terminal/cmd e clone o projeto do github com o seguinte comando:
```bash
  git clone https://github.com/luisscarlos/contabilidade-facil-api.git
```
- Em seguida, navege para a pasta do projeto que foi baixada:
```bash
  cd contabilidade-facil-api
```
- Agora, após ter o docker instalado na máquina em execução, execute o comando abaixo para iniciar o banco de dados no docker:
```bash
  docker-compose up -d
```
- Abra a IDE de sua preferência e importe o projeto (selecione a pasta contabilidade-facil-api que foi clonada do github) e aguarde o download de todas dependências do projeto
- Execute o arquivo com a classe main ContabilidadeFacilApplication.java
- Acesse a interface dos recursos do backend através do swagger usando o endereço local http://localhost:8080
