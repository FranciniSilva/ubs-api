package br.gov.dados.api.v1.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "Score", description = "Representa os dados de score da estrutura hospitalar")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScoreDTO {

	@ApiModelProperty(value = "Tamanho da unidade hospitalar", example = "3")
	private int size;
	
	@ApiModelProperty(value = "Tamanho da unidade hospitalar", example = "3")
	private int adaptation_for_seniors;
	
	@ApiModelProperty(value = "Tamanho da unidade hospitalar", example = "1")
	private int medical_equipment;
	
	@ApiModelProperty(value = "Tamanho da unidade hospitalar", example = "3")
	private int medicine;

	public static enum Score {
		DESEMPENHO_MEDIANA_OU_UM_POUCO_ABAIXO_DA_MEDIA(1, "Desempenho mediano ou  um pouco abaixo da média"),
		DESEMPENHO_ACIMA_DA_MEDIA(2, "Desempenho acima da média"),
		DESEMPENHO_MUITO_ACIMA_DA_MEDIA(3, "Desempenho muito acima da média");

		public int valorScore;
		public String descricao;

		Score(int valor, String descricao) {
			valorScore = valor;
			this.descricao = descricao;
		}

	}

}
