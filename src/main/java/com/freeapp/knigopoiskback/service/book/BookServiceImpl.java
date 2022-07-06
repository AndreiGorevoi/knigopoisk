package com.freeapp.knigopoiskback.service.book;

import com.freeapp.knigopoiskback.entity.Book;
import com.freeapp.knigopoiskback.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Andrei Gorevoi
 */
@Service
public class BookServiceImpl implements BookService {
  private final BookRepository bookRepository;

  @Autowired
  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public List<Book> getAll() {
    return bookRepository.findAll();
  }

  @Override
  public List<Book> getAllByGenre(String genre) {
    String capitalizedGenre = genre.substring(0,1).toUpperCase().concat(genre.substring(1));
    return bookRepository.findBooksByGenre(capitalizedGenre);
  }

  @Override
  public Book getById(UUID id) {
    return bookRepository.getById(id);
  }
}
