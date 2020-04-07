# ubs-api
<h1>API que lista as ubs mais próximas por latitude e longitude</h1>


Este projeto utiliza as seguintes ferramentas:
<em>Springboot, spring data, spring dev Tolls, mySQL, lombok, junit, springfox(open api swagger).</em>

Para executar este projeto é recomendável utilizar o STS.
No arquivo application.properties será encontrado as informações de banco de dados.
Modifique as informações de banco de dados de acordo com as configurações do seu mysql.
Crie uma base de dados chamada ubs no mysql para que o apontamento ocorra quando a aplicação for iniciada.
A base de dados precisa ser preenchida com o arquivo ubs.csv. Basta importar os dados do arquivo para a base ubs no mysql.

A api está documentada na url localhost:8080/swagger-ui.html
Esta url do swagger poderá ser consultada logo após a inicialização da aplicação.

Os testes de api estão disponíveis no caminho src/test/java no pacote br.gor.dados.
Basta executar a classe FindUbsIT para executar os testes de API.



