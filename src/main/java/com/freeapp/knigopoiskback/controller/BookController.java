package com.freeapp.knigopoiskback.controller;

import com.freeapp.knigopoiskback.entity.Book;
import com.freeapp.knigopoiskback.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author Andrei Gorevoi
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {

  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping(value = "/all")
  public ResponseEntity<List<Book>> getAll() {
    return ResponseEntity.ok(bookService.getAll());
  }

  @GetMapping(value = "/:id")
  public Book getById(@RequestParam UUID id) {
    return bookService.getById(id);
  }
}
