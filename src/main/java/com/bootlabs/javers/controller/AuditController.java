package com.bootlabs.javers.controller;


import com.bootlabs.javers.entities.Author;
import com.bootlabs.javers.entities.Book;
import com.bootlabs.javers.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.javers.core.Changes;
import org.javers.core.Javers;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * https://javers.org/documentation/jql-examples/
 * @author @bootteam
 */
@Slf4j
@RestController
@RequestMapping("/api/audit")
public class AuditController {

    private final Javers javers;
    private final AuthorService entityService;

    public AuditController(Javers javers, AuthorService entityService) {
        this.javers = javers;
        this.entityService = entityService;
    }

    @GetMapping("/book/snapshots")
    public String getBooksSnapshots() {
        QueryBuilder jqlQuery = QueryBuilder.byClass(Book.class);
        List<CdoSnapshot> snapshots = javers.findSnapshots(jqlQuery.build());
        return javers.getJsonConverter().toJson(snapshots);
    }


    @GetMapping("/author/snapshots")
    public String getAuthorsSnapshots() {
        QueryBuilder jqlQuery = QueryBuilder.byClass(Author.class);
        List<CdoSnapshot> snapshots = javers.findSnapshots(jqlQuery.build());
        return javers.getJsonConverter().toJson(snapshots);
    }


    @GetMapping("/author/{authorId}/changes")
    public String getAuthorByIdChanges(@PathVariable Long authorId) {
        Author author = entityService.getOne(authorId);
        QueryBuilder jqlQuery = QueryBuilder.byInstance(author);
        Changes changes = javers.findChanges(jqlQuery.build());
        log.info("Changes => {}", changes.prettyPrint());
        return javers.getJsonConverter().toJson(changes);
    }
}
