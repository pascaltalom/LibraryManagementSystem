package com.research.librarymanager_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.research.librarymanager_backend.Models.BookCopy;

public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {

}
