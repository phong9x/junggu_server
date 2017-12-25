package org.trams.junggu.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.trams.junggu.bean.jpa.IntroEntity;
import org.trams.junggu.bean.jpa.StoreEntity;

/**
 * Repository : Intro.
 */
public interface IntroJpaRepository extends PagingAndSortingRepository<IntroEntity, Integer> {
	@Modifying
	@Query(
			"Delete From IntroEntity"
			)
	void deleteAll();
}
