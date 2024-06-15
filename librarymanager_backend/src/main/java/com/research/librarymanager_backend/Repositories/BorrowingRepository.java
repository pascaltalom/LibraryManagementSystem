package com.research.librarymanager_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.research.librarymanager_backend.Models.Borrowing;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {

}
