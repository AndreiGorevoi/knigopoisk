package com.freeapp.knigopoiskback.repository;

import com.freeapp.knigopoiskback.entity.Genre;
import com.freeapp.knigopoiskback.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, UUID> {
  List<Genre> getAllByStatusIs(Status status);
}
