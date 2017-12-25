package org.trams.junggu.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.trams.junggu.bean.jpa.AccessibilityEntity;
import org.trams.junggu.bean.jpa.CategoryEntity;

/**
 * Repository : Accessibility.
 */
public interface AccessibilityJpaRepository extends PagingAndSortingRepository<AccessibilityEntity, Integer> {

	@Query(
			"Select c from AccessibilityEntity c where c.updateDate > ?1 "
			)
	List<AccessibilityEntity> findAllUpdate(java.util.Date updateDate, Pageable pageable);
	
	@Query(
			"select a from AccessibilityEntity a where a.name = ?1"
			)
	AccessibilityEntity finByAccessibilityName(String name);
}
