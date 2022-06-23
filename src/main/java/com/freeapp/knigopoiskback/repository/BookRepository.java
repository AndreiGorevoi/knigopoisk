package com.freeapp.knigopoiskback.repository;

import com.freeapp.knigopoiskback.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
