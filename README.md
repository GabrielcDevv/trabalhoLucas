#  Sistema de Lanchonete

Projeto acadêmico desenvolvido em **Java**, com uma aplicação de console para organizar produtos e clientes de uma lanchonete.

##  Sobre o projeto

O sistema utiliza menus interativos no terminal e conceitos de Programação Orientada a Objetos (POO), como classes, atributos privados, construtores, métodos getters e setters e listas de objetos.

Atualmente, o programa permite cadastrar e consultar produtos e cadastrar clientes, além de alterar informações já registradas durante a execução.

## Descrição do Problema

Foi Criado um sistema que permite cadastro/edição de produtos, clientes e pedidos.

##  Funcionalidades

### Produtos
- Cadastrar produtos dos tipos **comida** ou **bebida**.
- Informar nome e preço do produto.
- Listar os produtos cadastrados.
- Alterar o nome de um produto.
- Alterar o preço, com validação para impedir valores não positivos ou iguais ao preço atual.

### Clientes
- Cadastrar clientes com nome, endereço e telefone.
- Listar os clientes cadastrados.
- Alterar o nome, endereço ou telefone de um cliente.
- Evitar substituir um dado por outro igual ao valor atual.

### Pedidos
- Existe uma classe `Pedidos` com atributos para número do pedido, quantidade de produtos, status e capacidade.
- Criação de pedidos com integração de produtos e clientes cadastrados no sistema.

> **Observação:** os dados são armazenados em listas na memória durante a execução. O projeto não implementa persistência em banco de dados ou arquivos; ao encerrar o programa, os registros cadastrados são perdidos.

##  Tecnologias

- **Java**
- **Java Collections Framework** (`ArrayList` e `List`)
- **Scanner** para entrada de dados pelo terminal
- **Git e GitHub** para versionamento do código

##  Estrutura do projeto

```text
src/
└── Lanchonete/
    ├── Main.java       # Ponto de entrada e menus principais
    ├── Cliente.java    # Modelo de dados de cliente
    ├── Clientes.java   # Operações sobre a lista de clientes
    ├── Produto.java    # Modelo de dados de produto
    ├── Produtos.java   # Operações sobre a lista de produtos
    └── Pedidos.java    # Modelo de dados de pedido
```

##  Pré-requisitos

- **JDK 21 ou superior**, pois o código utiliza recursos de sintaxe moderna do Java e o método `List.addLast`.
- Um terminal ou uma IDE compatível com Java, como IntelliJ IDEA, Eclipse ou Visual Studio Code com suporte a Java.

Para verificar a instalação do Java:

```bash
java -version
javac -version
```

## Como executar

### 1. Baixe o repositório

```bash
git clone https://github.com/GabrielcDevv/trabalhoLucas.git
cd trabalhoLucas
```

### 2. Acesse a pasta que contém os arquivos Java

No pacote disponibilizado, os arquivos estão em:

```text
Downloads/faculdade/trabalhoLucas/src/Lanchonete
```

Ajuste o caminho conforme o local em que o repositório foi baixado ou extraído.

### 3. Compile os arquivos

A partir da pasta que contém o diretório `src`, execute:

```bash
javac -d out src/Lanchonete/*.java
```

### 4. Inicie a aplicação

```bash
java -cp out Lanchonete.Main
```

Se a estrutura de pastas do seu ambiente for diferente, ajuste os caminhos dos comandos para apontar para a pasta `src`.

##  Utilização

Ao iniciar, o programa apresenta um menu principal com opções para pedidos, produtos e clientes.

- **Produtos:** permite cadastrar produtos e modificar nome ou preço de itens existentes.
- **Clientes:** permite cadastrar clientes e modificar seus dados.
- **Pedidos:** a opção aparece no menu, mas ainda não possui fluxo de interação implementado.

Os cadastros são feitos pelo terminal, seguindo as perguntas e opções exibidas na tela.

##  Objetivo acadêmico

O projeto tem como objetivo praticar fundamentos de Java e organização de código em classes, aplicando conceitos de orientação a objetos em um cenário simples de gerenciamento de lanchonete.

##  Autoria

Erick Kran, Gabriel Campos e Wilames

## Divisão de responsabilidades

Erick: Responsável pelos clientes
Gabriel: Responsável pelos produtos
Wilames: Responsável pelos pedidos.
