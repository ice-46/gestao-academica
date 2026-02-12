# Gestão Acadêmica

Sistema Spring Boot com API REST e interface web para gerenciamento de cursos.

## Como executar

### 1) Rodar local com banco em memória (padrão)
```bash
mvn spring-boot:run
```
Acesse: `http://localhost:8080`

### 2) Rodar com PostgreSQL
Configure variáveis antes de subir:
```bash
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/gestao_academica_teste
export SPRING_DATASOURCE_USERNAME=postgres
export SPRING_DATASOURCE_PASSWORD=admin123
export SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.postgresql.Driver
mvn spring-boot:run
```

## Endpoints
- `GET /api/cursos`
- `GET /api/cursos/{id}`
- `POST /api/cursos`
- `PUT /api/cursos/{id}`
- `DELETE /api/cursos/{id}`

## Interface web
A UI está em `src/main/resources/static/index.html` e permite:
- listar cursos
- criar curso
- editar curso
- excluir curso
