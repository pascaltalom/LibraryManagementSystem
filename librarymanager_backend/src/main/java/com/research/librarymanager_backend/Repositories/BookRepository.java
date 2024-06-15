package com.research.librarymanager_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.research.librarymanager_backend.Models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
