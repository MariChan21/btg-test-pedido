# API btg-test-pedido 

Uma api Java que consiste em um microserviço para processar pedidos e uma API REST para consultar informações sobre os pedidos.

## Tecnologias Utilizadas

- Java
- Spring Boot
- MongoDB
- RabbitMQ
- REST API
- Lombok
- Docker

## Funcionalidades

1. **Microserviço de Processamento de Pedidos:**
    - O microserviço consome dados de uma fila RabbitMQ contendo informações de pedidos.
    - Os dados do pedido (código do pedido, código do cliente e itens) são gravados em um banco de dados MongoDB.
    - Isso permite a criação de registros de pedidos e a coleta de informações sobre os pedidos feitos.

2. **API REST de Consulta de Informações:**
    - A API REST fornece endpoints para consultar informações sobre os pedidos.
    - `api/pedido/`: Retorna lista de pedidos.
    - `api/pedido/`: Cria pedidos.
    - `api/pedido/total-valor-pedido/{codigoPedido}`: Retorna o valor total de um pedido.
    - `api/pedido/quantidade-pedidos-cliente/{codigoCliente}`: Retorna a quantidade de pedidos feitos por um cliente.
    - `api/pedido/{codigoCliente}`: Retorna a lista de pedidos realizados por um cliente.

## Instalação e Configuração

1. Certifique-se de ter o Java e o Maven instalados.
2. Clone este repositório: `git clone https://github.com/MariChan21/btg-test-pedido.git`
3. Navegue até o diretório do projeto: `cd aplicacao-gerenciamento-pedidos`
4. Execute o microserviço e a API REST: `mvn spring-boot:run`

## Exemplo de Consumo de Dados da Fila RabbitMQ

```json
{
  "codigoPedido": 1001,
  "codigoCliente": 1,
  "itens": [
    {
      "produto": "lápis",
      "quantidade": 100,
      "preco": 1.10
    },
    {
      "produto": "caderno",
      "quantidade": 10,
      "preco": 1.00
    }
  ]
}
