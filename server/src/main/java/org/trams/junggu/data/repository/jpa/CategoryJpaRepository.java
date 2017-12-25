package org.trams.junggu.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.trams.junggu.bean.jpa.CategoryEntity;
import org.trams.junggu.bean.jpa.NoticeEntity;

/**
 * Repository : Category.
 */
public interface CategoryJpaRepository extends PagingAndSortingRepository<CategoryEntity, Integer> {
	@Query(
			"Select c from CategoryEntity c where c.updateDate > ?1 "
			)
	List<CategoryEntity> findAllUpdate(java.util.Date updateDate, Pageable pageable);
	
	@Query(
			"Select c from CategoryEntity c where c.parentId =?1 "
			)
	List<CategoryEntity> findByGroupId(Integer parentId);
	
	@Query(
			"Select c from CategoryEntity c where c.catName = ?1"
			)
	CategoryEntity checkCategoryName(String name);
	
	@Query(
			"Select c from CategoryEntity c where c.parentId >0 "
			)
	List<CategoryEntity> findByDistrictId(Pageable pageable);
	
	@Query(
			"Select n from CategoryEntity n where n.catName like ?1 and n.isDelete !=1"
			)
	Page<CategoryEntity> listPaging(String key,Pageable pageable);
	
}
