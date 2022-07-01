package com.freeapp.knigopoiskback.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Andrei Gorevoi
 */
@Data
@Entity
@Table(name = "genre")
public class Genre extends BaseEntity {
  private String name;
}
