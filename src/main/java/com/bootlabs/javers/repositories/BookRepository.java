
package com.bootlabs.javers.repositories;

import com.bootlabs.javers.entities.Book;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <h2>BookRepository</h2>
 * Description: Spring Data repository for the {@link Book} entity.
 * 
 * @author @bootteam
 */
@JaversSpringDataAuditable
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
