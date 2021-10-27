# Desafio Pismo Teste pratico back-end - Case

Projeto desenvolvido com objetivo de avaliação em processo seletivo para entrevista técnica junto ao líder técnico e seu time.

## Requisitos

* Java 11+;
* Maven 3.6+;
* Docker 19.03+;
* Docker Compose 1.29+.

## Compilação do Projeto

Para compilar o projeto basta rodar comando de compilação padrão do Maven:

```bash
mvn clean install
 ```


## Como executar o projeto

Para execução do projeto está disponível no repositório um arquivo docker-compose com todas dependências necessárias. Este arquivo busca automaticamente dentro do contexto um arquivo dockerfile que está presente no projeto, ao iniciar a execução através do docker-compose o próprio dockerfile se encarrega de gerar os artefatos para disponibilizá-los para geração dinâmica do container da aplicação, não sendo necessário gerar manualmente os artefatos via maven.


```bash
# Comando para gerar o container Docker da aplicação
docker-compose up --build
```

# Documentação da API

Após o deploy é possível conferir a documentação da API em:

```shell
http://localhost:8080/api/swagger-ui/ 
```
