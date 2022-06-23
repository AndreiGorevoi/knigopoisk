package com.freeapp.knigopoiskback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * @author Andrei Gorevoi
 */
@Data
@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "second_name")
  private String secondName;

  @ManyToMany(mappedBy = "authors")
  @JsonIgnore
  private Set<Book> books;
}
