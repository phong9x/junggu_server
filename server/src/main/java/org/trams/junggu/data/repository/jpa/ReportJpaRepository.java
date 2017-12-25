package org.trams.junggu.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.trams.junggu.bean.jpa.ReportEntity;
import org.trams.junggu.bean.jpa.UserEntity;

/**
 * Repository : Report.
 */
public interface ReportJpaRepository extends PagingAndSortingRepository<ReportEntity, Integer> {

	@Query(
			"Select u From ReportEntity u where u.isDelete!=1"
			)
	Page<ReportEntity> listPaging(Pageable pageable);
	
	@Query(
			"Select u From ReportEntity u Where u.store.id = ?1 and u.phoneNumber = ?2 and u.isDelete=0"
			)
	ReportEntity findByStoreReporter(Integer storeId,String phoneNumber);
	
	@Query(
			"Select u From ReportEntity u Where u.userId = ?1 and u.store.id = ?2 and u.isDelete=0"
			)
	ReportEntity findByStoreReporter(Integer userId,Integer storeId);
	
	@Query(
			"Select u From ReportEntity u Where u.userId = ?1 and u.store.id = ?2 and u.isDelete=0"
			)
	List<ReportEntity> listByStoreReporter(Integer userId,Integer storeId);
	
	@Query(
			"Select u From ReportEntity u Where u.store.id = ?1 and u.isDelete=0"
			)
	List<ReportEntity> listByStore(Integer storeId);
}
