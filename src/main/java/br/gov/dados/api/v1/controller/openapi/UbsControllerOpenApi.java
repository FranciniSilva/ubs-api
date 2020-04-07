package br.gov.dados.api.v1.controller.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.gov.dados.api.v1.dto.ResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "UBS")
public interface UbsControllerOpenApi {

	@ApiOperation("Busca unidades basica de saude(ubs) mais proximas por latitude e longitude")
	public ResponseEntity<List<ResponseDTO>> findUbs(
			@ApiParam("Valores de latitude e longitude separados por virgula") List<String> query,
			@ApiParam(value = "Valor da pagina que sera exibido", example = "1") int page,
			@ApiParam(value = "Quantidade de itens exibidos por pagina", example = "2")  int per_page);

}
