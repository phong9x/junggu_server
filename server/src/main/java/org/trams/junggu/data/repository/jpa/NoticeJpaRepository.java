package org.trams.junggu.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.trams.junggu.bean.jpa.NoticeEntity;

/**
 * Repository : Notice.
 */
public interface NoticeJpaRepository extends PagingAndSortingRepository<NoticeEntity, Integer> {
@Query(
		"Select n from NoticeEntity n where n.isDelete !=1"
		)
Page<NoticeEntity> listPaging(Pageable pageable);

@Query(
		"Select c from NoticeEntity c where c.updateDate > ?1 "
		)
List<NoticeEntity> findAllUpdate(java.util.Date updateDate, Pageable pageable);
}
