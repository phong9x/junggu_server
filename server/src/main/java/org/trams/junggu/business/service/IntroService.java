/*
 * Created on 9 Nov 2015 ( Time 15:25:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.business.service;

import java.util.List;
import org.trams.junggu.bean.jpa.IntroEntity;
import org.trams.junggu.bean.Intro;
import org.springframework.data.domain.Page;

/**
 * Business Service Interface for entity Intro.
 */
public interface IntroService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	Intro findById( Integer id  ) ;

	/** 
	 * Loads all entities.
	 * @return all entities
	 */
	List<Intro> findAll();
	
	/**
	 * Loads entities in page number.
	 * @return entities
	 */

	Page<IntroEntity> findAll(Integer page);

	/**
	 * Count all entities
	 * @return Long
	 */
	Long countTotal();
	

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Intro save(Intro entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Intro update(Intro entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Intro create(Intro entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );
	void deleteAll();

}
