package com.freeapp.knigopoiskback.service.genre;

import com.freeapp.knigopoiskback.entity.Genre;
import com.freeapp.knigopoiskback.entity.Status;
import com.freeapp.knigopoiskback.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Andrei Gorevoi
 */
@Service
public class GenreServiceImpl implements GenreService {
  private final GenreRepository genreRepository;

  @Autowired
  public GenreServiceImpl(GenreRepository repository) {
    this.genreRepository = repository;
  }

  @Override
  public List<Genre> getAll() {
    return genreRepository.findAll();
  }

  @Override
  public List<Genre> getAllActives() {
    return genreRepository.getAllByStatusIs(Status.ACTIVE);
  }
}
