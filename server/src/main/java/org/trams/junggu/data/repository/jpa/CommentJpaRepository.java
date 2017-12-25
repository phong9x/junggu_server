package org.trams.junggu.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.trams.junggu.bean.jpa.CommentEntity;
import org.trams.junggu.bean.jpa.UserEntity;

/**
 * Repository : Comment.
 */
public interface CommentJpaRepository extends PagingAndSortingRepository<CommentEntity, Integer> {

	@Query(
			"select c From CommentEntity c where c.userId = ?1 and c.storeId = ?2"
			)
	CommentEntity checkExitsComment(Integer userId, Integer storeId);
	
	@Query(
			value="select count(*) as cnt, sum(GRADE) as grade from comment where STORE_ID = ?1 ",nativeQuery = true
			)
	List<Integer[]> getSumGradeByStoreId(int storeId);
	@Query(
			"select c From CommentEntity c where c.updateDate > ?1 "
			)
	List<CommentEntity> findAllUpdate(Date updateDate,Pageable pageable);
	
	@Query(
			"Select u From CommentEntity u where u.userId =?1"
			)
	Page<CommentEntity> findAllByUser(Integer id,Pageable pageable);
	
	@Query(
			"Select u From CommentEntity u where u.userId =?1"
			)
	List<CommentEntity> findAllByUser(Integer id);
	
	@Query(
			"Select u From CommentEntity u where u.storeId =?1 and u.isDelete=0"
			)
	Page<CommentEntity> findAllByStore(Integer storeId,Pageable pageable);
	
	@Query(
			"Select u From CommentEntity u where u.userId =?1 and u.storeId =?2"
			)
	Page<CommentEntity> listPagingByReport(Integer userId,Integer storeId,Pageable pageable);
	
	@Query(
			value="select count(*)  from comment where STORE_ID = ?1 ",nativeQuery = true
			)
	Integer totalComment_ByStoreId(Integer storeId);
	
}
