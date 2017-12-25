package org.trams.junggu.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.trams.junggu.bean.jpa.InfoEntity;

/**
 * Repository : Info.
 */
public interface InfoJpaRepository extends PagingAndSortingRepository<InfoEntity, Integer> {
	@Query(
			"Select c from InfoEntity c where c.updateDate > ?1 "
			)
	List<InfoEntity> findAllUpdate(java.util.Date updateDate,Pageable pageable);
}
