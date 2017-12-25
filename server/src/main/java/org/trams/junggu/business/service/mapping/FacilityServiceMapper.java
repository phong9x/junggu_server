/*
 * Created on 11 Dec 2015 ( Time 20:38:41 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.trams.junggu.bean.Facility;
import org.trams.junggu.bean.jpa.FacilityEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class FacilityServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public FacilityServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'FacilityEntity' to 'Facility'
	 * @param facilityEntity
	 */
	public Facility mapFacilityEntityToFacility(FacilityEntity facilityEntity) {
		if(facilityEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Facility facility = map(facilityEntity, Facility.class);

		return facility;
	}
	
	/**
	 * Mapping from 'Facility' to 'FacilityEntity'
	 * @param facility
	 * @param facilityEntity
	 */
	public void mapFacilityToFacilityEntity(Facility facility, FacilityEntity facilityEntity) {
		if(facility == null) {
			return;
		}

		//--- Generic mapping 
		map(facility, facilityEntity);

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