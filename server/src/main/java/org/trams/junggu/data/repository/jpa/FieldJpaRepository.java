package org.trams.junggu.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.trams.junggu.bean.jpa.CategoryEntity;
import org.trams.junggu.bean.jpa.FacilityEntity;
import org.trams.junggu.bean.jpa.FieldEntity;

/**
 * Repository : Field.
 */
public interface FieldJpaRepository extends PagingAndSortingRepository<FieldEntity, Integer> {

	@Query(
			"Select c from FieldEntity c where c.updateDate > ?1 "
			)
	List<FieldEntity> findAllUpdate(java.util.Date updateDate,Pageable pageable);
	
	@Query(
			"Select c from FieldEntity c where c.isDelete=0 "
			)
	List<FieldEntity> listField(Pageable pageable);
	
	@Query(
			"Select n from FieldEntity n where n.name like ?1 and n.isDelete !=1"
			)
	Page<FieldEntity> listPaging(String key,Pageable pageable);
}
