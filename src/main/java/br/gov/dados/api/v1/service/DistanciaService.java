package br.gov.dados.api.v1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import br.gov.dados.api.v1.dto.EntriesDTO;
import br.gov.dados.api.v1.dto.ResponseDTO;
import br.gov.dados.api.v1.model.Ubs;
import br.gov.dados.api.v1.repository.UbsRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DistanciaService {

	private UbsRepository repo;

	public List<ResponseDTO> findUbs(String vlrLatitude, String vlrLongitude, Pageable page) {
		return calculaDistanciaEntreUbs(vlrLatitude, vlrLongitude, page);
	}

	private List<ResponseDTO> calculaDistanciaEntreUbs(String vlrLatitude, String vlrLongitude, Pageable page) {
		// Default radius.
		Integer radius = 5;

		double vlrLatitudeParse = Double.parseDouble(vlrLatitude);
		double vlrLongitudeParse = Double.parseDouble(vlrLongitude);

		// Define center.
		LatLng center = new LatLng(vlrLatitudeParse, vlrLongitudeParse);

		// Get latitude west and east of center.
		LatLng latitude_west = LatLngTool.travel(center, 180, radius, LengthUnit.KILOMETER);
		LatLng latitude_east = LatLngTool.travel(center, 0, radius, LengthUnit.KILOMETER);

		// Get longitude south and north of center.
		LatLng longitude_south = LatLngTool.travel(center, 270, radius, LengthUnit.KILOMETER);
		LatLng longitude_north = LatLngTool.travel(center, 90, radius, LengthUnit.KILOMETER);

		// Convert back to latitude and longitude and form a imperfect square.
		Double lat_west = (Double) latitude_west.getLatitude();
		Double lat_east = (Double) latitude_east.getLatitude();
		Double lng_south = (Double) longitude_south.getLongitude();
		Double lng_north = (Double) longitude_north.getLongitude();

		Page<Ubs> listUbs = repo.findByVlrLatitudeBetweenAndVlrLongitudeBetween(lat_west, lat_east, lng_south,
				lng_north, page);

		List<ResponseDTO> responseDTOs = new ArrayList<>();
		List<EntriesDTO> entriesDTOs = new ArrayList<>();
		ResponseDTO responseDTO = new ResponseDTO();

		for (Ubs ubs : listUbs) {
			entriesDTOs.add(EntriesDTO.ubsEntriesToEntriesDTO(ubs));
			responseDTO.setEntries(entriesDTOs);
		}
		responseDTOs.add(responseDTO);

		responseDTOs.get(0).setCurrentPage(page.getPageNumber());
		responseDTOs.get(0).setPerPage((page.getPageSize()));
		responseDTOs.get(0).setTotalEntries(listUbs.getTotalElements());

		return responseDTOs;
	}

}
