package com.freeapp.knigopoiskback.service.author;

import com.freeapp.knigopoiskback.entity.Author;
import com.freeapp.knigopoiskback.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author Andrei Gorevoi
 */
@Service
public class AuthorServiceImpl implements AuthorService {

  private final AuthorRepository authorRepository;

  @Autowired
  public AuthorServiceImpl(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @Override
  public List<Author> getAll() {
    return authorRepository.findAll();
  }

  @Override
  public Author getById(UUID id) {
    return authorRepository.getById(id);
  }
}
