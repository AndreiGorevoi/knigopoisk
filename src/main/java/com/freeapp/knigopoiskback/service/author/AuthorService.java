package com.freeapp.knigopoiskback.service.author;

import com.freeapp.knigopoiskback.entity.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
  List<Author> getAll();

  Author getById(UUID id);
}
