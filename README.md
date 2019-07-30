# HotelApp

**Teste 1**

Construir uma api calculando o *totalPrice* para os hotéis retornados do seguinte broker:

*https://cvcbackendhotel.herokuapp.com/hotels/avail/{ID_da_Cidade}*

Detalhes do serviço:

URL: Construa a URL como achar melhor Method: GET

Parametros obrigatórios:

CityCode
Checkin
Checkout
Quantidade de Adultos
Quantidade de Crianças
Exemplo de utilização para o serviço criado:

*http://localhost:8080/hotelApi/totalPriceHotels?city=1032&checkin=05/08/2019&checkout=10/08/2019&numAdult=1&numChild=1*

checkin e checkout devem seguir a seguinte forma dd/mm/yyyy

Exemplo de response:

[ { "id": 1, "cityName": "Porto Seguro", "rooms": [ { "roomID": 0, "categoryName": "Standard", "price": { "adult": 1372.54, "child": 848.61, "totalPrice": 15865.35 } } ] } ]

**Teste 2**

Construir um form com os campos Cidade, Checkin, Checkout, quantidade de adultos e quantidade de crianças. Ao preencher as informações e envia-lás, exibir o resultado obtido da API desenvolvida no teste 1 em uma lista na tela.

Tela para o serviço:

*http://localhost:8080/hotelApi/*
