package org.trams.junggu.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.trams.junggu.bean.jpa.FacilityEntity;
import org.trams.junggu.bean.jpa.StoreEntity;

/**
 * Repository : Store.
 */
public interface StoreJpaRepository extends PagingAndSortingRepository<StoreEntity, Integer> {
	@Query(
			"Select c from StoreEntity c where c.updateDate > ?1 "
			)
	List<StoreEntity> findAllUpdate(java.util.Date updateDate, Pageable pageable);
	
	@Query(
			"Select c from StoreEntity c where c.isDelete!=1"
			)
	Page<StoreEntity> listPaging(Pageable pageable);
	
	@Query(
			"Select c from StoreEntity c where c.name like %?1% and c.isDelete!=1"
			)
	Page<StoreEntity> findALlByCompanyName(String name,Pageable pageable);
	
	@Query(
			"Select c from StoreEntity c where c.fieldList like %?1% and c.isDelete!=1"
			)
	Page<StoreEntity> findALlByCategory(String catid,Pageable pageable);
	
	@Query(
			"Select c from StoreEntity c where c.address like %?1% and c.isDelete!=1"
			)
	Page<StoreEntity> findALlByAdress(String address,Pageable pageable);
	
	@Query(
			"Select c from StoreEntity c where c.representative like %?1% and c.isDelete!=1"
			)
	Page<StoreEntity> findALlByRepresentative(String representative,Pageable pageable);
	
	@Query(
			"Select c from StoreEntity c where c.phone like %?1% and c.isDelete!=1"
			)
	Page<StoreEntity> findALlByMainPhone(String phone,Pageable pageable);
	
	@Query(
			value="Select name From store where _id=?1",nativeQuery = true
			)
	String getNameStore(Integer id);
}
