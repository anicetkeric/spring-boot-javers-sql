
package com.bootlabs.javers.repositories;

import com.bootlabs.javers.entities.Author;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <h2>AuthorRepository</h2>
 * Description: Spring Data repository for the {@link Author} entity.
 * 
 * @author @bootteam
 */
@JaversSpringDataAuditable
@Repository
public interface AuthorRepository  extends JpaRepository<Author, Long> {

}
