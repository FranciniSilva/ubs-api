package br.gov.dados.api.v1.dto;

import br.gov.dados.api.v1.model.Ubs;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "Entries", description = "Representa os atributos de uma unidade basica de saude")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EntriesDTO {
	
	@ApiModelProperty(value = "ID da ubs", example = "39860")
	private Long id;
	
	@ApiModelProperty(value = "Nome da ubs", example = "UBS REAL PQ PAULO MANGABEIRA ALBERNAZ FILHO")
	private String name;
	
	@ApiModelProperty(value = "Endereco da ubs", example = "RUA BARAO MELGACO")
	private String address;
	 
	@ApiModelProperty(value = "Cidade da ubs", example = "São Paulo")
	private String city;
	
	@ApiModelProperty(value = "Telefone da ubs", example = "1137582329")
	private String phone;
	
	private GeocodeDTO geocode;
	private ScoreDTO score;

	public static EntriesDTO ubsEntriesToEntriesDTO(Ubs ubs) {

		EntriesDTO entriesDTO = new EntriesDTO();
		ScoreDTO score = new ScoreDTO();

		entriesDTO.setId(ubs.getId());
		entriesDTO.setName(ubs.getNomEstab());
		entriesDTO.setAddress(ubs.getDscEndereco());
		entriesDTO.setCity(ubs.getDscCidade());
		entriesDTO.setPhone(ubs.getDscTelefone());
		entriesDTO.setGeocode(new GeocodeDTO(ubs.getVlrLatitude(), ubs.getVlrLongitude()));

		if (ubs.getDscEstrutFisicAmbiencia()
				.equalsIgnoreCase(ScoreDTO.Score.DESEMPENHO_MEDIANA_OU_UM_POUCO_ABAIXO_DA_MEDIA.descricao)) {
			score.setSize((ScoreDTO.Score.DESEMPENHO_MEDIANA_OU_UM_POUCO_ABAIXO_DA_MEDIA.valorScore));
		} else if (ubs.getDscEstrutFisicAmbiencia()
				.equalsIgnoreCase(ScoreDTO.Score.DESEMPENHO_ACIMA_DA_MEDIA.descricao)) {
			score.setSize((ScoreDTO.Score.DESEMPENHO_ACIMA_DA_MEDIA.valorScore));
		} else {
			score.setSize((ScoreDTO.Score.DESEMPENHO_MUITO_ACIMA_DA_MEDIA.valorScore));

		}

		if (ubs.getDscAdapDeficFisicIdosos()
				.equalsIgnoreCase(ScoreDTO.Score.DESEMPENHO_MEDIANA_OU_UM_POUCO_ABAIXO_DA_MEDIA.descricao)) {
			score.setAdaptation_for_seniors((ScoreDTO.Score.DESEMPENHO_MEDIANA_OU_UM_POUCO_ABAIXO_DA_MEDIA.valorScore));
		} else if (ubs.getDscAdapDeficFisicIdosos()
				.equalsIgnoreCase(ScoreDTO.Score.DESEMPENHO_ACIMA_DA_MEDIA.descricao)) {
			score.setAdaptation_for_seniors((ScoreDTO.Score.DESEMPENHO_ACIMA_DA_MEDIA.valorScore));
		} else {
			score.setAdaptation_for_seniors((ScoreDTO.Score.DESEMPENHO_MUITO_ACIMA_DA_MEDIA.valorScore));

		}

		if (ubs.getDscEquipamentos()
				.equalsIgnoreCase(ScoreDTO.Score.DESEMPENHO_MEDIANA_OU_UM_POUCO_ABAIXO_DA_MEDIA.descricao)) {
			score.setMedical_equipment((ScoreDTO.Score.DESEMPENHO_MEDIANA_OU_UM_POUCO_ABAIXO_DA_MEDIA.valorScore));
		} else if (ubs.getDscEstrutFisicAmbiencia()
				.equalsIgnoreCase(ScoreDTO.Score.DESEMPENHO_ACIMA_DA_MEDIA.descricao)) {
			score.setMedical_equipment((ScoreDTO.Score.DESEMPENHO_ACIMA_DA_MEDIA.valorScore));
		} else {
			score.setMedical_equipment((ScoreDTO.Score.DESEMPENHO_MUITO_ACIMA_DA_MEDIA.valorScore));

		}

		if (ubs.getDscMedicamentos()
				.equalsIgnoreCase(ScoreDTO.Score.DESEMPENHO_MEDIANA_OU_UM_POUCO_ABAIXO_DA_MEDIA.descricao)) {
			score.setMedicine((ScoreDTO.Score.DESEMPENHO_MEDIANA_OU_UM_POUCO_ABAIXO_DA_MEDIA.valorScore));
		} else if (ubs.getDscEstrutFisicAmbiencia()
				.equalsIgnoreCase(ScoreDTO.Score.DESEMPENHO_ACIMA_DA_MEDIA.descricao)) {
			score.setMedicine((ScoreDTO.Score.DESEMPENHO_ACIMA_DA_MEDIA.valorScore));
		} else {
			score.setMedicine((ScoreDTO.Score.DESEMPENHO_MUITO_ACIMA_DA_MEDIA.valorScore));

		}

		entriesDTO.setScore(new ScoreDTO(score.getSize(), score.getAdaptation_for_seniors(),
				score.getMedical_equipment(), score.getMedicine()));

		return entriesDTO;

	}

}
