package org.trams.junggu.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.trams.junggu.bean.jpa.ServerEntity;

/**
 * Repository : Server.
 */
public interface ServerJpaRepository extends PagingAndSortingRepository<ServerEntity, Integer> {
	@Query(
			"Select c from ServerEntity c where c.updateDate > ?1 "
			)
	List<ServerEntity> findAllUpdate(java.util.Date updateDate, Pageable pageable);
}
