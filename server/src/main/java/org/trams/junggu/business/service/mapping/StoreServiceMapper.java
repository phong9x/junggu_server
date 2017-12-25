/*
 * Created on 11 Dec 2015 ( Time 20:38:41 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.trams.junggu.bean.Store;
import org.trams.junggu.bean.jpa.StoreEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class StoreServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public StoreServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'StoreEntity' to 'Store'
	 * @param storeEntity
	 */
	public Store mapStoreEntityToStore(StoreEntity storeEntity) {
		if(storeEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Store store = map(storeEntity, Store.class);

		return store;
	}
	
	/**
	 * Mapping from 'Store' to 'StoreEntity'
	 * @param store
	 * @param storeEntity
	 */
	public void mapStoreToStoreEntity(Store store, StoreEntity storeEntity) {
		if(store == null) {
			return;
		}

		//--- Generic mapping 
		map(store, storeEntity);

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}