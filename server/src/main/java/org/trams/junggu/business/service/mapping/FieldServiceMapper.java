/*
 * Created on 11 Dec 2015 ( Time 20:38:41 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.trams.junggu.bean.Field;
import org.trams.junggu.bean.jpa.FieldEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class FieldServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public FieldServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'FieldEntity' to 'Field'
	 * @param fieldEntity
	 */
	public Field mapFieldEntityToField(FieldEntity fieldEntity) {
		if(fieldEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Field field = map(fieldEntity, Field.class);

		return field;
	}
	
	/**
	 * Mapping from 'Field' to 'FieldEntity'
	 * @param field
	 * @param fieldEntity
	 */
	public void mapFieldToFieldEntity(Field field, FieldEntity fieldEntity) {
		if(field == null) {
			return;
		}

		//--- Generic mapping 
		map(field, fieldEntity);

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