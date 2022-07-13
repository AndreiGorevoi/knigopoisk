package com.freeapp.knigopoiskback.controller;

import com.freeapp.knigopoiskback.entity.Book;
import com.freeapp.knigopoiskback.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
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

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping(value = "/all")
  public ResponseEntity<List<Book>> getAll() {
    return ResponseEntity.ok(bookService.getAll());
  }

  @GetMapping
  public ResponseEntity<List<Book>> getByGenre(@RequestParam String genre) {
    if(genre.equalsIgnoreCase("all")) return ResponseEntity.ok(bookService.getAll());
    return ResponseEntity.ok(bookService.getAllByGenre(genre));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Book> getById(@PathVariable UUID id) {
    if (bookService.getById(id).isPresent()) {
      return ResponseEntity.ok(bookService.getById(id).get());
    }
    return ResponseEntity.notFound().build();
  }

  @PatchMapping(value = "/{id}")
  public ResponseEntity<Integer> patchById(@PathVariable UUID id, @RequestParam String newOwner){
    bookService.updateBookById(id, newOwner);
    return ResponseEntity.ok(HttpServletResponse.SC_OK);
  }
}
