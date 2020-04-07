package br.gov.dados.api.v1.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.dados.api.v1.controller.openapi.UbsControllerOpenApi;
import br.gov.dados.api.v1.dto.ResponseDTO;
import br.gov.dados.api.v1.service.DistanciaService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public class UbsController implements UbsControllerOpenApi{

	private DistanciaService distanciaService;

	@GetMapping("find_ubs")
	public ResponseEntity<List<ResponseDTO>> findUbs(@RequestParam List<String> query, @RequestParam int page, @RequestParam int per_page) {
		Pageable paginacao = PageRequest.of(page, per_page);
		List<ResponseDTO> listUbs = distanciaService.findUbs(query.get(0), query.get(1), paginacao);

		return ResponseEntity.ok(listUbs);
	}

}
