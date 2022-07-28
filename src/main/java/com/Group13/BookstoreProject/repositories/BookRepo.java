package com.Group13.BookstoreProject.repositories;
import com.Group13.BookstoreProject.models.Bookgenre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepo extends MongoRepository<Bookgenre,String> {

    @Query("{'isbn' : ?0}")
    Bookgenre searchBookByisbnRepo(String i);

    @Query("{'authorName' : ?0}")
    List<Bookgenre> searchBookByAuthorRepo(String a);

    // @Query("{'title' : ?0}")

    @Query("{'genre' : ?0}")
    List<Bookgenre> searchBookByGenre(String g);

}
