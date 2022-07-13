package com.freeapp.knigopoiskback.service.book;

import com.freeapp.knigopoiskback.entity.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {
  List<Book> getAll();
  List<Book> getAllByGenre(String genre);
  Optional<Book> getById(UUID id);
  void updateBookById(UUID id, String newOwner);
}
