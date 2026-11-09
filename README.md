# API de Pagamentos

Projeto de estudo em Java e Spring Boot para praticar o padrão de projeto **Strategy** em uma API REST.

> Os pagamentos são apenas simulados. A aplicação não se conecta a bancos, adquirentes ou serviços de pagamento, e não salva transações.

## O que a API faz

A API recebe o valor e o método de pagamento e escolhe a estratégia correspondente:

- `PIX`
- `CARTAO`

O valor precisa ser maior que zero e o método de pagamento não pode estar vazio. A comparação do método ignora diferenças entre letras maiúsculas e minúsculas.

## Padrão Strategy

A interface `FormaPagamento` define o contrato comum. `PagamentoPix` e `PagamentoCartao` implementam esse contrato. O `PagamentoService` encontra a estratégia pelo código informado e chama seu processamento.

O Spring registra as estratégias como componentes e as disponibiliza para o serviço.

## Tecnologias

- Java 17
- Spring Boot 3.3.5
- Maven
- Spring Web
- Bean Validation
- Springdoc OpenAPI / Swagger UI

## Endpoint

### Processar um pagamento

`POST /pagamentos`

Exemplo de requisição:

```json
{
  "valor": 100.00,
  "metodoPagamento": "PIX"
}
```

A resposta é uma mensagem de texto indicando o método e o valor processados. Por exemplo:

```text
Processando pagamento via PIX no valor de: 100.00
```

## Documentação interativa

Com a aplicação em execução, acesse:

- Swagger UI: http://localhost:8080/swagger-ui/index.html
- Especificação OpenAPI: http://localhost:8080/v3/api-docs

## Como executar

É necessário ter o Java 17 instalado. Na pasta do projeto, execute:

```bash
./mvnw spring-boot:run
```

No Windows, use:

```bat
mvnw.cmd spring-boot:run
```

## Exemplo com cURL

```bash
curl -X POST \
  http://localhost:8080/pagamentos \
  -H 'Content-Type: application/json' \
  -d '{"valor":100.00,"metodoPagamento":"PIX"}'
```

## Organização do código

- `controller`: recebe as requisições HTTP.
- `dto`: representa os dados recebidos.
- `pagamento`: contém a interface e as estratégias de pagamento.
- `service`: seleciona e executa a estratégia adequada.
