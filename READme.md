# Desafio de lançamentos financeiros

## :rocket: Implementação do desafio proposto aqui: https://dev.to/zanfranceschi/desafio-desenhar-uma-solucao-a-partir-de-requisitos-lancamentos-financeiros-33g3

Mantive os mesmos requisitos e adicionei mais funcionalidades para enriquecer o projeto. O objetivo é criar uma aplicação
que lide com lançamentos financeiros e transferências de dinheiro entre clientes de um banco

## Stack
 - Java 17
 - Spring Boot v3.0.0
 - SQL com Postgres
 - NoSQL com Redis
 - Mensageria com RabbitMQ

## Arquitetura
Inicialmente a aplicação roda em monolito, com todas as funcionalidades dentro da mesma JVM. Uma parte dos requisitos do desafio
é migrar cada domínio para serviços separados e será feito ao finalizar os requisitos funcionais. Dentro do monolito, implementei
4 componentes principais, baseados na Arquitetura Hexagonal. São eles:

  - **domain**: apenas classes Java puras, descrevendo entidades, _excpetions_ e _ports_ de cada domínio
  - **application**: implementação de _ports_ que descrevem regras de negócio
  - **endpoint**: implementação da camada de entrada da app, podendo conter _Controllers_ REST, _listeners_ de mensageria, processos agendados com CRON, etc
  - **infrastructure**: implementação de _ports_ que descrevem os detalhes de infra, como integrações com bancos SQL/noSQL, serviços externos, etc...

A arquitetura segue duas regras básicas. Primeiro é sempre ter a primeira camada de pacotes de cada componente descrevendo o domínio 
e não as tecnologias utilizadas, vide [Screaming Architecture](https://blog.cleancoder.com/uncle-bob/2011/09/30/Screaming-Architecture.html). 
A segunda regra estabelece os limites de interação entre componentes, onde o componente _domain_ não deve interajir com nenhum outro e todos os outros devem 
interajir apenas com _domain_, usando as interfaces de _ports_. Dessa forma, o domínio centraliza todas as funcionalidades e os 
componentes não precisam conhecer a nenhum outro exceto o próprio domínio. Devido ao fato desses limites serem apenas
um acordo formal (para evitar complexidade, utilizei _packages_ do Java mas o ideal seria ter cada componente em projetos Maven 
distintos, fisicamente separados), existem testes unitários com [ArchUnit](https://www.archunit.org/) assegurando esses limites.

## TODO
 - Finalizar requisitos funcionais e implementações de infra
 - Adicionar docker-compose com um ambiente completo da aplicação