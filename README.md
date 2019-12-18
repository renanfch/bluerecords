# Blue Records

API para compra e vendas de discos de vinil; 

Stack utilizada:

* Linguagem: [`Java`](https://www.oracle.com/technetwork/java/javase/downloads/index.html) / [`Kotlin`](https://kotlinlang.org) 
* Compilação: [`Gradle`](https://gradle.org)
* Framework: [`Spring Boot`](https://spring.io/projects/spring-boot)
* Cache: [`Caffeine`](https://github.com/ben-manes/caffeine)
* Banco de dados: [`H2`](h2database.com) / [`Flyway`](https://flywaydb.org)
* Documentação: [`Swagger`](https://swagger.io)
* Tests: 
    * Teste de unidade [`jUnit5`](https://junit.org/junit5/docs/current/user-guide/) 
    * Ferramenta para mocks [`Mockk`](https://mockk.io)
    * Ferramenta para cobertura de tests [`Jacoco`](https://www.jacoco.org)
* Deploy: [`Gradle Cargo Plugin`](https://github.com/bmuschko/gradle-cargo-plugin)
* Log: []
* CI / CD: []

## Arquitetura

<img src="documentation/images/CleanArchitecture.jpg" width="400" >

A estrutura do projeto foi desenvolvido pensando no conceito do 
[`Clean Architecture`](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html), 
que divide a aplicação em módulos:

* **Configuration** - Configurações do Framework, injeção de dependências, define
as implementações e realiza a união do projeto como um todo

* **Core** - Regra de negócio, essa módulo é livre de qualquer tipo de framework
para deixar a regra independente de tecnologia e de fácil manutenção, nessa camada
temos duas vertentes:
    * **entity** - Entidades, objetos que representam o negócio
    * **use case** - Casos de uso do projeto, como um `Service`, implementa 
    funcionalidades e regras especificas de cada funcionalidade.

* **Data Provider** - Camada responsável em fornecer os dados para o `core`
implementando suas interfaces.

* **Entry Points** - Responsável em fornecer os end-points, essa
camada trata os dados que o usuário envia processa utilizando os `use cases`
do `core` e trata seu retorno.

A idéia de utilizar o `Clean Architecture` é para tornar o sistema
manutenível, testável e flexível a alterações drásticas, atravéz dessa estrutura
também temos um ganho ao lidarmos com várias pessoas alterando o mesmo código; 

## Documentação

**Buscar discos** GET http://localhost:9000/disco ?generoId={id}&pagina={pagina}&tamanho={tamanho}

**Buscar disco** GET http://localhost:9000/disco/{id} 

**Registrar venda** POST http://localhost:9000/venda

**Buscar vendas** GET http://localhost:9000/venda ?dataInicial={dataI}&dataFinal={dataF}&pagina={pagina}&tamanho={tamanho}
  
**Buscar venda** GET http://localhost:9000/venda/{id}

## Documentação dinâmica

O `Swagger` nos proporciona uma documentação dinâmica para os end-points
do projeto, também nos dando liberdade para efetuar execuções.


Link: [http://localhost:9000/swagger-ui.html]


## Observações
Tentei utilizar o mínimo de frameworks e bibliotecas possíveis, poderia ser utilizado JPA para persistência e paginação.