package com.freeapp.knigopoiskback.controller;

import com.freeapp.knigopoiskback.entity.Genre;
import com.freeapp.knigopoiskback.service.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Andrei Gorevoi
 */
@RestController
@RequestMapping("/genre")
public class GenreController {

  private final GenreService genreService;

  @Autowired
  public GenreController(GenreService genreService) {
    this.genreService = genreService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Genre>> getAll() {
    return ResponseEntity.ok(genreService.getAllActives());
  }
}
