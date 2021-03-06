/*
 * Created on 11 Dec 2015 ( Time 20:38:41 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.trams.junggu.bean.Intro;
import org.trams.junggu.bean.jpa.IntroEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class IntroServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public IntroServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'IntroEntity' to 'Intro'
	 * @param introEntity
	 */
	public Intro mapIntroEntityToIntro(IntroEntity introEntity) {
		if(introEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Intro intro = map(introEntity, Intro.class);

		return intro;
	}
	
	/**
	 * Mapping from 'Intro' to 'IntroEntity'
	 * @param intro
	 * @param introEntity
	 */
	public void mapIntroToIntroEntity(Intro intro, IntroEntity introEntity) {
		if(intro == null) {
			return;
		}

		//--- Generic mapping 
		map(intro, introEntity);

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