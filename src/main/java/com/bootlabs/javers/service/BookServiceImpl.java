package com.bootlabs.javers.service;


import com.bootlabs.javers.entities.Book;
import com.bootlabs.javers.repositories.BookRepository;
import org.javers.spring.annotation.JaversAuditableDelete;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link Book}.
 *
 * @author @bootteam
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book create(Book d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book update(Book d) {
        return repository.saveAndFlush(d);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book getOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getTotal() {
        return repository.count();
    }

    /**
     * {@inheritDoc}
     */
    @JaversAuditableDelete
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
