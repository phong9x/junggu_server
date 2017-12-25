package org.trams.junggu.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.trams.junggu.bean.jpa.CategoryEntity;
import org.trams.junggu.bean.jpa.FacilityEntity;

/**
 * Repository : Facility.
 */
public interface FacilityJpaRepository extends PagingAndSortingRepository<FacilityEntity, Integer> {
	@Query(
			"Select c from FacilityEntity c where c.updateDate > ?1 "
			)
	List<FacilityEntity> findAllUpdate(java.util.Date updateDate,Pageable pageable);
	
	@Query(
			"Select n from FacilityEntity n where n.name like ?1 and n.isDelete !=1"
			)
	Page<FacilityEntity> listPaging(String key,Pageable pageable);
}
