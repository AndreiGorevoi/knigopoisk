package com.freeapp.knigopoiskback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

/**
 * @author Andrei Gorevoi
 */

@Data
@Entity
@Table(name = "books")
public class Book extends BaseEntity {

  @Column(name = "title")
  private String title;

  @Column(name = "genre")
  private String genre;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "books_authors", joinColumns = {
      @JoinColumn(name = "book_id", referencedColumnName = "id") }, inverseJoinColumns = {
      @JoinColumn(name = "author_id", referencedColumnName = "id") })
  private List<Author> authors;
}
