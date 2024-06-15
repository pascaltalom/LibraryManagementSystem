package com.research.librarymanager_backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Exceptions.BorrowingNotFoundException;
import com.research.librarymanager_backend.Models.Borrowing;
import com.research.librarymanager_backend.Repositories.BorrowingRepository;

@Service
public class BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    public BorrowingService(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }

    // Create borrowing
    public Borrowing createBorrowing(Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }

    // Get All Borrowings
    public List<Borrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }

    // Get Borrowings By Id
    public Borrowing getBorrowingById(Long borrowId) {
        return borrowingRepository.findById(borrowId).orElseThrow(()->new BorrowingNotFoundException("borrowing with id"+ borrowId +"Not Found"));
    }

    // Update Borrowing
    public Borrowing updateBorrowing(Borrowing borrowing) {
        return borrowingRepository.save(borrowing); 
    }

    // Delete borrowing
    public void deleteBorrowing(Long borrowId) {
        borrowingRepository.deleteById(borrowId);
    }
}
