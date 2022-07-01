package com.freeapp.knigopoiskback.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Andrei Gorevoi
 */

@Data
@Entity
@Table(name = "books")
public class Book extends BaseEntity {

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @ManyToOne(cascade = CascadeType.ALL)
  private Genre genre;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "books_authors", joinColumns = {
      @JoinColumn(name = "book_id", referencedColumnName = "id") }, inverseJoinColumns = {
      @JoinColumn(name = "author_id", referencedColumnName = "id") })
  private List<Author> authors;
}
