package br.gov.dados.api.v1.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@ApiModel(value = "Geocode", description = "Representa um objeto com os valores de latirude e longitude do endereco")
@Getter
@AllArgsConstructor
public class GeocodeDTO {
	
	@ApiModelProperty(value = "Latitude", example = "-23.6099946498864")
	private Double lat;
	
	@ApiModelProperty(value = "Longitude", example = "-46.7057347297655")
	private Double lon;

}
