
# Java Biblioteca 

Este projeto é um sistema simples de gerenciamento de biblioteca desenvolvido em Java. Ele permite gerenciar uma coleção de livros e usuários, além de controlar empréstimos e devoluções.



## Funcionalidades

- Listar livros disponíveis na coleção
- Listar usuários cadastrados no sistema
- Buscar livros por título e autor
- Adicionar e remover livros da coleção
- Adicionar e remover usuários do sistema
- Realizar empréstimos e devoluções de livros


## Estrutura

- `Livro.java`: Classe que representa um livro com título, autor e status de disponibilidade.
- `Usuario.java`: Classe que representa um usuário com nome, CPF e lista de livros emprestados.
- `Biblioteca.java`: Classe que gerencia as coleções de livros e usuários, e controla as operações do sistema.
- `Main.java`: Classe principal com interface via terminal para interação com o usuário.
## Instalação

- Clonar o repositório
```bash
git clone https://github.com/lucas-jurgensen/java.biblioteca.git
```

- Compilar os arquivos `.java`
```bash
javac *.java
```

- Execute a aplicação
```bash
java Main
```
    
## Requisitos

- Java JDK 8 ou superior instalado
- Ambiente de linha de comando para compilar e executar programas Java
## Uso/Exemplos

```bash
[1] - Listar livros
[2] - Listar usuários
[3] - Buscar livros
[4] - Adicionar livros
[5] - Remover livros
[6] - Adicionar usuários
[7] - Remover usuários
[8] - Emprestar livros
[9] - Devolver livros
[0] - Sair
Sua opção: 4
Digite o título do livro:
O Senhor dos Anéis
Digite o autor do livro:
J.R.R. Tolkien
Livro adicionado à coleção da Biblioteca com sucesso
```

