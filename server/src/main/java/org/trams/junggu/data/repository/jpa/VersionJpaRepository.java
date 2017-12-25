package org.trams.junggu.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.trams.junggu.bean.jpa.FacilityEntity;
import org.trams.junggu.bean.jpa.VersionEntity;

/**
 * Repository : Version.
 */
public interface VersionJpaRepository extends PagingAndSortingRepository<VersionEntity, Integer> {
	@Query(
			"Select c from VersionEntity c where c.updateDate > ?1 "
			)
	List<VersionEntity> findAllUpdate(java.util.Date updateDate,Pageable pageable);
}
