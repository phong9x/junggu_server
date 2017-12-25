/*
 * Created on 25 Dec 2015 ( Time 11:25:54 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.trams.junggu.bean.Field;
import org.trams.junggu.bean.Info;
import org.trams.junggu.bean.jpa.FieldEntity;
import org.trams.junggu.bean.jpa.InfoEntity;
import java.util.Date;
import org.trams.junggu.business.service.InfoService;
import org.trams.junggu.business.service.mapping.InfoServiceMapper;
import org.trams.junggu.data.repository.jpa.InfoJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of InfoService
 */
@Component
@Transactional
public class InfoServiceImpl implements InfoService {

	@Resource
	private InfoJpaRepository infoJpaRepository;

	private static final Integer PAGE_SIZE   = 15;

	@Resource
	private InfoServiceMapper infoServiceMapper;
	
	@Override
	public Info findById(Integer id) {
		InfoEntity infoEntity = infoJpaRepository.findOne(id);
		return infoServiceMapper.mapInfoEntityToInfo(infoEntity);
	}

	@Override
	public Page<InfoEntity> findAll(Integer pageNumber) {

		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE,
				new Sort(new Order(Direction.DESC, "id")));
		return infoJpaRepository.findAll(request);
	}

	@Override
	public List<Info> findAll() {
		Iterable<InfoEntity> entities = infoJpaRepository.findAll();
		List<Info> beans = new ArrayList<Info>();
		for(InfoEntity infoEntity : entities) {
			beans.add(infoServiceMapper.mapInfoEntityToInfo(infoEntity));
		}
		return beans;
	}
	
	@Override
	public List<Info> findAllUpdate(Date updateDate) {
		PageRequest request = new PageRequest(0, 5000, new Sort(new Order(Direction.ASC, "updateDate")));
		Iterable<InfoEntity> entities = infoJpaRepository.findAllUpdate(updateDate,request);
		List<Info> beans = new ArrayList<Info>();
		for(InfoEntity fieldEntity : entities) {
			beans.add(infoServiceMapper.mapInfoEntityToInfo(fieldEntity));
		}
		return beans;
	}

	/**
	 * Count total entit
	 * @return Long
	 */
	public Long countTotal(){
		Long count = infoJpaRepository.count();
		return count;
	}

	@Override
	public Info save(Info info) {
		return update(info) ;
	}

	@Override
	public Info create(Info info) {
/*
		InfoEntity infoEntity = infoJpaRepository.findOne(info.getId());
		if( infoEntity != null ) {
			throw new IllegalStateException("already.exists");
		}

		infoEntity = new InfoEntity();
		infoServiceMapper.mapInfoToInfoEntity(info, infoEntity);
		InfoEntity infoEntitySaved = infoJpaRepository.save(infoEntity);
		return infoServiceMapper.mapInfoEntityToInfo(infoEntitySaved);
*/
		InfoEntity infoEntity = new InfoEntity();
		infoServiceMapper.mapInfoToInfoEntity(info, infoEntity);
		InfoEntity infoEntitySaved = infoJpaRepository.save(infoEntity);
		return infoServiceMapper.mapInfoEntityToInfo(infoEntitySaved);
	}

	@Override
	public Info update(Info info) {
		InfoEntity infoEntity = infoJpaRepository.findOne(info.getId());
		infoServiceMapper.mapInfoToInfoEntity(info, infoEntity);
		InfoEntity infoEntitySaved = infoJpaRepository.save(infoEntity);
		return infoServiceMapper.mapInfoEntityToInfo(infoEntitySaved);
	}

	@Override
	public void delete(Integer id) {
		infoJpaRepository.delete(id);
	}

	public InfoJpaRepository getInfoJpaRepository() {
		return infoJpaRepository;
	}

	public void setInfoJpaRepository(InfoJpaRepository infoJpaRepository) {
		this.infoJpaRepository = infoJpaRepository;
	}

	public InfoServiceMapper getInfoServiceMapper() {
		return infoServiceMapper;
	}

	public void setInfoServiceMapper(InfoServiceMapper infoServiceMapper) {
		this.infoServiceMapper = infoServiceMapper;
	}

}