# Consulta FIPE - Java 21 + Spring + API Pública

Este projeto foi desenvolvido como prática dos conceitos aprendidos no curso **"Java: trabalhando com lambdas, streams e Spring Framework"** da Alura. A aplicação realiza o **consumo da API da Tabela FIPE** para consultar preços de veículos, utilizando **Java 21**, **Spring Boot** (sem interface web), **lambdas** e **streams**.

## Funcionalidades

- Escolha de categoria de veículo: **carro, moto ou caminhão**
- Listagem de marcas da categoria escolhida com seus respectivos códigos
- Listagem e filtro de modelos por nome
- Exibição dos anos disponíveis para o modelo selecionado
- Consulta dos **valores e detalhes** para cada ano

## Como funciona

Toda a interação é feita via terminal. O usuário navega pelas seguintes etapas:
1. Escolhe a categoria do veículo
2. Seleciona uma marca
3. Filtra modelos por um trecho do nome
4. Seleciona um modelo pelo código
5. Visualiza os valores e dados disponíveis por ano

## Tecnologias utilizadas

- Java 21
- Spring Boot (sem interface web)
- Maven
- Consumo de API REST
- Streams e Lambdas
