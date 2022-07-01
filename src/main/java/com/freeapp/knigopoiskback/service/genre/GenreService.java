package com.freeapp.knigopoiskback.service.genre;

import com.freeapp.knigopoiskback.entity.Genre;

import java.util.List;

public interface GenreService {
  List<Genre> getAll();

  List<Genre> getAllActives();
}
