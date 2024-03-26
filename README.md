# Covid Benchmark API

## Sobre o projeto

O Covid Benchmark API visa fazer uma análise estatística dos dados da covid em alguns países

A aplicação consiste em uma api em que o usuário informa dois países a serem comparados, e a data inicial e final,

A partir disso ele ele compila e realiza o processamento desses dados para estatísticas.

### Tecnologias utilizadas

* Java
* Spring Boot
* JPA / Hibernate / H2
* Maven
* Swagger

### Processo de criação

A api foi criada consumindo a api da [Covid 19](https://api.api-ninjas.com/v1/covid19)

Nela recebiamos um json ao consultas os casos ou mortes de um país

```json
{
	"country": "Brazil",
	"region": "",
	"cases": {
		"2020-08-01": {
			"total": 2711992,
			"new": 41541
		},
		"2020-08-02": {
			"total": 2736058,
			"new": 24066
		}
	}
}
```

Com isso, fazemos uma requisição tanto dos dados de casos e mortes de um país e tratamos internamente

Depois tratamos a importação desses dados para o banco de dados JPA, armazenando também os Jsons com dados já tratados

Após a criação dela, basta consultar a benchmark na api irá trazer dados como pico, média, taxa de mortalidade entre outros

 
## API de Benchmarks de Comparação 

Esta API permite realizar operações de benchmarks entre países, criando e gerenciando benchmarks de comparação.

Apenas um breve resumo para mais detalhes e teste verificar no Swagger

### Endpoints Disponíveis


### Criar Benchmark

Cria uma benchmark entre dois países e retorna um resumo.



* **URL**
  `/api/benchmark/total/criar/`

* **Método POST**

Body:

``` json
{
  "nome": "Benchmark 01",
  "nomePais1": "Brasil",
  "nomePais2": "Argentina",
  "dataInicial": "2023-01-01",
  "dataFinal": "2024-01-01"
}
```

Os países devem ser informados em português, com ou sem acentuação

E as datas devem ser sempre informadas no formado 'yyyy-MM-dd'

### Listar Benchmarks

Disponibiliza uma lista de resumos das benchmarks.

* **URL** `/api/benchmark/total/lista`

* **Método GET**

### Obter Benchmark Pelo ID

Obtém uma benchmark pelo seu ID.

* **URL** `/api/benchmark/total/{id}/`
* **Método GET**

Parâmetros

* **id** : id da Benchmark

### Deletar Benchmark Pelo ID

* **URL** `/api/benchmark/total/{id}`
* **Método DELETE**

Parâmetros

* **id** : id da Benchmark

### Obtem Benchmark Por País
Retorna o benchmark de um país

* **URL** `/api/benchmark/pais/{pais}/{dataInicial}/{dataFinal}`

* **Método GET**

* **Parâmetros**
  - pais - Nome do país para o qual criar a benchmark
  - dataInicial - Data inicial da benchmark (formato: yyyy-MM-dd)
  - dataFinal - Data final da benchmark (formato: yyyy-MM-dd)

### Obter Lista de Países

Obtém uma lista dos países disponíveis.

* **URL**
  `/api/paises/lista/`

* **Método GET**

### Obter Lista de Países Sem Acentuação

Obtém uma lista dos países disponíveis sem acentuação.

* **URL**
  `/api/paises/lista/sem-acentuacao`
* **Método GET**
