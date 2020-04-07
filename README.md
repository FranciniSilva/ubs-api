# ubs-api
<h1>API que lista as ubs mais próximas por latitude e longitude</h1>


Este projeto utiliza as seguintes ferramentas:
<em>Springboot, spring data, spring dev Tolls, mySQL, lombok, junit, springfox(open api swagger).</em>

Para executar este projeto é recomendável utilizar o STS.

No arquivo application.properties estão as informações de banco de dados, como mostra a imagem abaixo:

![Screenshot_3](https://user-images.githubusercontent.com/20953270/78671248-6bba3300-78b5-11ea-9158-9b1ea3664d57.png)

Modifique as informações de banco de dados de acordo com as configurações do seu mysql.

Crie uma base de dados chamada ubs no mysql para que o apontamento ocorra quando a aplicação for iniciada.

A base de dados precisa ser preenchida com o arquivo ubs.csv. Basta importar os dados do arquivo para a base ubs no mysql.

Para inicializar a aplicação basta executar a classe UbsApiApplication, como mostra a imagem abaixo:

![Screenshot_1](https://user-images.githubusercontent.com/20953270/78671233-665ce880-78b5-11ea-80d8-3f29ec1ad032.png)

Para chamar a API utilize o POSTman ou o curl, conforme sua preferência, utilizando a uri localhost:8080/api/v1/find_ubs?query=-23.604936,-46.692999&page=1&per_page=2

![Screenshot_2](https://user-images.githubusercontent.com/20953270/78671241-6957d900-78b5-11ea-9a69-9b3f865532d2.png)

A resposta obtida será essa:

![Screenshot_4](https://user-images.githubusercontent.com/20953270/78671273-75dc3180-78b5-11ea-9586-05e054f24563.png)

A api está documentada na url localhost:8080/swagger-ui.html

Esta url do swagger poderá ser consultada logo após a inicialização da aplicação.

No swagger é possível encontrar todas as informações sobre a api e o endpoint conforme imagem abaixo:
![Screenshot_6](https://user-images.githubusercontent.com/20953270/78671279-7674c800-78b5-11ea-846d-4738e1b35521.png)

Para executar o end point find_ubs basta clicar no botao Try it out conforme mostra a imagem abaixo:

![Screenshot_7](https://user-images.githubusercontent.com/20953270/78671280-7674c800-78b5-11ea-97b2-27e33b031add.png)

Os parâmetros obrigatórios estarão preenchidos automaticamente como mostra a imagem abaixo:

![Screenshot_13](https://user-images.githubusercontent.com/20953270/78672811-87bed400-78b7-11ea-91ad-b8f277b4f083.png)

Basta clicar em execute para obter a resposta do endpoint:
![Screenshot_9](https://user-images.githubusercontent.com/20953270/78671283-770d5e80-78b5-11ea-93c5-df75f99188a3.png)

Na documentação também e possível ver as informações dos modelos:
![Screenshot_11](https://user-images.githubusercontent.com/20953270/78671287-77a5f500-78b5-11ea-8e65-0c1734cdaf3e.png)

Os testes de api estão disponíveis no caminho src/test/java no pacote br.gov.dados.
Para executar os testes basta abrir a classe e executar com o junit:
![Screenshot_12](https://user-images.githubusercontent.com/20953270/78671269-74ab0480-78b5-11ea-874e-2f1f3b504035.png)
