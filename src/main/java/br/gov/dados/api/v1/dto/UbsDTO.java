package br.gov.dados.api.v1.dto;

import br.gov.dados.api.v1.model.Ubs;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UbsDTO {

	private Long id;
	private Double vlrLatitude;
	private Double vlrLongitude;
	private Integer codMunic;
	private Integer codCnes;
	private String nomEstab;
	private String dscEndereco;
	private String dscBairro;
	private String dscCidade;
	private String dscTelefone;
	private String dscEstrutFisicAmbiencia;
	private String dscAdapDeficFisicIdosos;
	private String dscEquipamentos;
	private String dscMedicamentos;

	public UbsDTO(Ubs ubs) {
		this(ubs.getId(), ubs.getVlrLatitude(), ubs.getVlrLongitude(), ubs.getCodMunic(), ubs.getCodCnes(),
				ubs.getNomEstab(), ubs.getDscEndereco(), ubs.getDscBairro(), ubs.getDscCidade(),
				ubs.getDscTelefone(), ubs.getDscEstrutFisicAmbiencia(), ubs.getDscAdapDeficFisicIdosos(),
				ubs.getDscEquipamentos(), ubs.getDscMedicamentos());
	}

}
