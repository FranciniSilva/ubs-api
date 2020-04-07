package br.gov.dados.api.v1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ubs {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Double vlrLatitude;

	@NonNull
	private Double vlrLongitude;

	@NonNull
	private Integer codMunic;
	@NonNull
	private Integer codCnes;
	@NonNull
	private String nomEstab;
	@NonNull
	private String dscEndereco;
	@NonNull
	private String dscBairro;
	@NonNull
	private String dscCidade;
	@NonNull
	private String dscTelefone;
	@NonNull
	private String dscEstrutFisicAmbiencia;
	@NonNull
	private String dscAdapDeficFisicIdosos;
	@NonNull
	private String dscEquipamentos;
	@NonNull
	private String dscMedicamentos;

}
