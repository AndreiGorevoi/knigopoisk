package com.freeapp.knigopoiskback.controller;

import com.freeapp.knigopoiskback.entity.Book;
import com.freeapp.knigopoiskback.repository.BookRepository;
import com.freeapp.knigopoiskback.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

  private final BookService bookService;
//  TODO: delete after testing
  private final BookRepository bookRepository;

  @Autowired
  public BookController(BookService bookService, BookRepository bookRepository) {
    this.bookService = bookService;
    this.bookRepository = bookRepository;
  }

  @GetMapping(value = "/all")
  public ResponseEntity<List<Book>> getAll() {
    return ResponseEntity.ok(bookService.getAll());
  }

  @GetMapping(value = "/{genre}")
  public ResponseEntity<List<Book>> getByGenre(@PathVariable String genre){
    return ResponseEntity.ok(bookService.getAllByGenre(genre));
  }

  @GetMapping(value = "/:id")
  public Book getById(@RequestParam UUID id) {
    return bookService.getById(id);
  }
}
