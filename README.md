# MottuAPI - Gestão de Motos em Pátios

Este projeto foi desenvolvido como parte do **Challenge 2025 - 1º Semestre** da FIAP, em parceria com a empresa 🛵 **Mottu**.

A aplicação consiste em uma API REST para realizar o mapeamento inteligente de motos nos pátios das filiais da Mottu, incluindo funcionalidades como cadastro, atualização, listagem, busca por placa, paginação, ordenação e validação de coordenadas das motos dentro dos limites do pátio.

---

## 👨‍💻 Alunos do Grupo

| Nome Completo | RM     |
|---------------|--------|
| Renan Dorneles | RM557820 |
| Cauan da Cruz | RM558238 |
| Igor Barrocal| RM555217 |

---

## 🚀 Tecnologias Utilizadas

- Java 17  
- Spring Boot 3.4.5  
- Spring Web  
- Spring Data JPA  
- H2 Database  
- Bean Validation  
- Spring Cache  
- Maven  
- IntelliJ/VS Code  

---

## 📦 Como Executar o Projeto

### 1. Pré-requisitos
- Java 17 instalado
- Maven instalado
- IDE (recomendado: IntelliJ ou VS Code)

### 2. Clone o repositório

```bash
git clone https://github.com/SEU_USUARIO/mottuapi.git
cd mottuapi

```


3. Compile e execute a aplicação

   
```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em:
```bash
http://localhost:8080
```

5. Acessar console do banco de dados H2
   
URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:mottudb


🔗 Endpoints principais
🛵 Motos
GET /motos – Listar motos (com paginação e ordenação)

GET /motos/{id} – Buscar moto por ID

GET /motos/buscar?placa=XYZ1234 – Buscar moto por placa

POST /motos – Cadastrar nova moto

PUT /motos/{id} – Atualizar moto

DELETE /motos/{id} – Remover moto

🏢 Pátios
GET /patios – Listar pátios

GET /patios/{id} – Buscar pátio por ID

POST /patios – Cadastrar pátio

DELETE /patios/{id} – Remover pátio

✅ Funcionalidades Implementadas

 CRUD completo para Motos e Pátios
 Relacionamento entre entidades (Moto pertence a um Pátio)
 Validação de coordenadas dentro do pátio
 Bean Validation nos DTOs
 DTOs para entrada e saída de dados
 Paginação e ordenação
 Busca por placa
 Cache de listagem
 Tratamento centralizado de erros
