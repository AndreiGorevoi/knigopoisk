package com.freeapp.knigopoiskback.entity;

import lombok.Data;
import org.apache.catalina.User;

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

  @ManyToOne(cascade = CascadeType.ALL)
  private AppUser owner;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "books_authors", joinColumns = {
      @JoinColumn(name = "book_id", referencedColumnName = "id") }, inverseJoinColumns = {
      @JoinColumn(name = "author_id", referencedColumnName = "id") })
  private List<Author> authors;

  @Override
  public String toString() {
    return "Book{" + "title='" + title + '\'' + ", description='" + description + '\'' + '}';
  }
}
