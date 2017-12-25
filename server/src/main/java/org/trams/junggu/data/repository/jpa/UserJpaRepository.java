package org.trams.junggu.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.trams.junggu.bean.jpa.FacilityEntity;
import org.trams.junggu.bean.jpa.UserEntity;

/**
 * Repository : User.
 */
public interface UserJpaRepository extends PagingAndSortingRepository<UserEntity, Integer> {
	@Query(
			"Select u From UserEntity u Where u.username = ?1 and u.password = ?2 and u.role = ?3"
			)

	UserEntity login(String username,String password, Integer role);
	
	@Query(
			"Select u From UserEntity u Where u.username = ?1 "
			)

	UserEntity findByUsername(String username);
	@Query(
			"Select c from UserEntity c where c.updateDate > ?1 "
			)
	List<UserEntity> findAllUpdate(java.util.Date updateDate,Pageable pageable);
	
	@Query(
			"Select u From UserEntity u where u.role=0 and u.isDelete!=1 "
			)
	Page<UserEntity> listPaging(Pageable pageable);
	
	@Query(
			"Select u From UserEntity u where u.username like %?1% and u.role=0 and u.isDelete!=1"
			)
	Page<UserEntity> findAllById(String id,Pageable pageable);
	
	@Query(
			"Select u From UserEntity u where u.phone like %?1% and u.role=0 and u.isDelete!=1"
			)
	Page<UserEntity> findAllByMobileNumber(String phone,Pageable pageable);
}
