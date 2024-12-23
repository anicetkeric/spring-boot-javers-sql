package com.bootlabs.javers.service;
import com.bootlabs.javers.entities.Author;

import java.util.List;

/**
 * Service Interface for managing {@link Author}.
*  @author @bootteam
 */
public interface AuthorService  {
   
    /**
     * create new item for domain
     *
     * @param entity entity to save.
     * @return persisted entity Author
     */
    Author create(Author entity);

    /**
     * Update entity. Check before if existing data. If data is empty throw Exception
     *
     * @param entity domain
     * @return Author
     */
    Author update(Author entity);

    /**
     * get Author by id. Can be return empty
     *
     * @param id the id of the entity.
     * @return Author
     */
    Author getOne(Long id) ;

    /**
     * Get all entities
     *
     * @return list of entities List<Author>
     */
    List<Author> getAll();

    /**
     * Count item in entity
     *
     * @return long 
     */
    long getTotal();

    /**
     * Delete record by id
     *  
     */
    void delete(Long id);

}
