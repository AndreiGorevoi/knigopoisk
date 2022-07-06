package com.freeapp.knigopoiskback.repository;

import com.freeapp.knigopoiskback.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {

  @Query("from Book b where b.genre.name = ?1")
  List<Book> findBooksByGenre(String genre);
}
