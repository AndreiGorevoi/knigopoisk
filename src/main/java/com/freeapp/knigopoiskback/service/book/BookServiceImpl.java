package com.freeapp.knigopoiskback.service.book;

import com.freeapp.knigopoiskback.entity.AppUser;
import com.freeapp.knigopoiskback.entity.Book;
import com.freeapp.knigopoiskback.repository.AppUserRepository;
import com.freeapp.knigopoiskback.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Andrei Gorevoi
 */
@Service
public class BookServiceImpl implements BookService {
  private final BookRepository bookRepository;
  private final AppUserRepository appUserRepository;

  @Autowired
  public BookServiceImpl(BookRepository bookRepository, AppUserRepository appUserRepository) {
    this.bookRepository = bookRepository;
    this.appUserRepository = appUserRepository;
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
  public Optional<Book> getById(UUID id) {
    return bookRepository.findById(id);
  }

  @Override
  public void updateBookById(UUID id, String newOwner) {
    AppUser newOwnerAppUser = appUserRepository.findAppUserByLogin(newOwner);
    bookRepository.findById(id).ifPresent(book -> {
      book.setOwner(newOwnerAppUser);
      bookRepository.save(book);
    });
  }
}
