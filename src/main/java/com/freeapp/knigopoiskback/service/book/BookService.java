package com.freeapp.knigopoiskback.service.book;

import com.freeapp.knigopoiskback.entity.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {
  List<Book> getAll();
  Book getById(UUID id);
}
