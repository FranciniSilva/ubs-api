package br.gov.dados.api.v1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.gov.dados.api.v1.model.Ubs;

public interface UbsRepository extends PagingAndSortingRepository<Ubs, Long> {

	Page<Ubs> findByVlrLatitudeBetweenAndVlrLongitudeBetween(Double lat_east, Double lat_west, Double lng_south,
			Double lng_north, Pageable pageable);

}
