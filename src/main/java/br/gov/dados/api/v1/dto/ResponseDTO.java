package br.gov.dados.api.v1.dto;

import java.util.ArrayList;
import java.util.List;

import br.gov.dados.api.v1.model.Ubs;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "Response", description = "Representa a resposta do servico formatada")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDTO {

	@ApiModelProperty(value = "Pagina atual")
	private int currentPage;
	
	@ApiModelProperty(value = "Itens apresentados por pagina")
	private int perPage;
	
	@ApiModelProperty(value = "Total de ubs listados")
	private Long totalEntries;
	
	private List<EntriesDTO> entries;

	public static ResponseDTO ubsToResponseDTO(Ubs ubs) {

		ResponseDTO responseDTO = new ResponseDTO();
		EntriesDTO entries = new EntriesDTO();
		List<EntriesDTO> listEntries = new ArrayList<>();

		entries.setId(ubs.getId());
		entries.setName(ubs.getNomEstab());
		entries.setAddress(ubs.getDscEndereco());
		entries.setCity(ubs.getDscCidade());
		entries.setPhone(ubs.getDscTelefone());
		entries.setGeocode(new GeocodeDTO(ubs.getVlrLatitude(), ubs.getVlrLongitude()));
		listEntries.add(entries);

		responseDTO.setEntries(listEntries);

		return responseDTO;

	}

}
