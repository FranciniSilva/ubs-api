package br.gov.dados;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FindUbsIT {

	@LocalServerPort
	private int port;

	@BeforeEach
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/api/v1/find_ubs";
	}

	@Test
	public void deveRetornarStatus200_QuandoConsultarUbs() {

		RestAssured
		.given()
		.queryParam("query", "-23.604936, -46.692999")
		.queryParam("page", "1")
		.queryParam("per_page", "6")
		.accept(ContentType.JSON)
		.when()
		.get()
		.then()
		.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarStatus500_QuandoInserirPageSizeZero() {

		RestAssured
		.given()
		.queryParam("query", "-23.604936, -46.692999")
		.queryParam("page", "1")
		.queryParam("per_page", "0")
		.accept(ContentType.JSON)
		.when()
		.get()
		.then()
		.statusCode(500);
	}
	
	@Test
	public void deveRetornarStatus400_QuandoNaoInserirParametroQueryNaUri() {

		RestAssured
		.given()
		.accept(ContentType.JSON)
		.when()
		.get()
		.then()
		.statusCode(400);
	}
	
	
	@Test
	public void deveRetornarStatus400_QuandoInserirLetrasNaUri() {

		RestAssured
		.given()
		.queryParam("query", "-23.604936, -46.692999")
		.queryParam("page", "a")
		.queryParam("per_page", "a")
		.accept(ContentType.JSON)
		.when()
		.get()
		.then()
		.statusCode(400);
	}
}
