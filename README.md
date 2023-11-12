# MyPokemons

## 1. Introdução

O MyPokemon é um projeto Spring Boot desenvolvido para gerenciar informações sobre Pokémon. Este relatório fornece uma visão geral do projeto, incluindo requisitos, configuração, uso do Docker, endpoints da API e informações sobre contribuições e licença.

## 2. Requisitos

Para começar a trabalhar no projeto, é necessário ter as seguintes ferramentas instaladas:

- Java 11
- Maven
- Docker

## 3. Configuração

### 3.1 Clonando o Repositório

Clone o repositório usando o seguinte comando:

```bash
git clone https://github.com/ZiemanJoao/MyPokemons.git
```

### 3.2 Configurando o Ambiente

Abra o projeto em sua IDE preferida e certifique-se de configurar o ambiente para suportar o Lombok.

### 3.3 Executando o Aplicativo

Execute o aplicativo Spring Boot com o seguinte comando:

```bash
mvn spring-boot:run
```

O aplicativo estará disponível em `http://localhost:8080`.

## 4. Banco de Dados H2

O MyPokemon utiliza um banco de dados H2 embutido. O console do H2 pode ser acessado em `http://localhost:8080/h2` com as seguintes configurações:

- JDBC URL: `jdbc:h2:mem:testdb`
- User Name: `pokemon`
- Password: `pokemon`

## 5. Docker

O aplicativo também pode ser executado usando Docker. Certifique-se de ter o Docker instalado e execute os seguintes comandos no diretório do projeto:

```bash
docker build -t mypokemon .
docker run -p 8080:8080 mypokemon
```

O aplicativo estará disponível em `http://localhost:8080`.

## 6. Endpoints da API

Todos os endpoints da API estão sob o caminho `/pokemons`. Aqui estão os principais endpoints:

### 6.1 Listar todos os Pokémon

```http
GET /pokemons
```

Exemplo de resposta:

```json
{
  "listPokemon": [
    {
      "id": 1,
      "nome": "Pikachu",
      "tipo": "Elétrico",
      "nivel": 30,
      "pokebola": "Ultra Ball"
    },
    {
      "id": 2,
      "nome": "Bulbasaur",
      "tipo": "Grama/Veneno",
      "nivel": 20,
      "pokebola": "Great Ball"
    }
  ]
}
```

### 6.2 Obter um Pokémon por ID

```http
GET /pokemons/{id}
```

Exemplo de resposta:

```json
{
    "id": 1,
    "nome": "Pikachu",
    "tipo": "Elétrico",
    "nivel": 30,
    "pokebola": "Ultra Ball"
}
```

### 6.3 Criar um novo Pokémon

```http
POST /pokemons
```

Exemplo de corpo da solicitação:

```json
{
    "nome": "Charmander",
    "tipo": "Fogo",
    "nivel": 25,
    "pokebola": "Great Ball"
}
```

### 6.4 Atualizar o nível de um Pokémon

```http
PUT /pokemons/{id}
```

Exemplo de corpo da solicitação:

```json
35
```

### 6.5 Deletar um Pokémon por ID

```http
DELETE /pokemons/{id}
```

## 7. Contribuindo

O projeto MyPokemon foi desenvolvido por João Pedro Aranda (RA: 202107185) e Gustavo Postigo (RA: 202118917) como parte do trabalho da disciplina de Programação Orientada a Objetos.

Sinta-se à vontade para contribuir para o MyPokemon. Faça um fork do repositório, faça suas alterações e envie um pull request!

## 8. Licença

Este projeto está licenciado sob a MIT License - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
