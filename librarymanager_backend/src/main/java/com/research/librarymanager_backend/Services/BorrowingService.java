package com.research.librarymanager_backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Models.Borrowing;
import com.research.librarymanager_backend.Repositories.BorrowingRepository;

@Service
public class BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

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
        Optional<Borrowing> borrowing = borrowingRepository.findById(borrowId);
        return borrowing.orElse(null);
    }

    // Update Borrowing
    public Borrowing updateBorrowing(Long borrowId, Borrowing borrowing) {
        Optional<Borrowing> existingBorrowing = borrowingRepository.findById(borrowId);
        if (existingBorrowing.isPresent()) {
            Borrowing updatedBorrowing = existingBorrowing.get();
            updatedBorrowing.setBookCopy(borrowing.getBookCopy());
            updatedBorrowing.setBorrowDate(borrowing.getBorrowDate());
            updatedBorrowing.setReturnDate(borrowing.getReturnDate());
            updatedBorrowing.setDueDate(borrowing.getDueDate());
            updatedBorrowing.setMember(borrowing.getMember());
            return borrowingRepository.save(updatedBorrowing);
        }
        return null;
    }

    // Delete borrowing
    public void deleteBorrowing(Long borrowId) {
        borrowingRepository.deleteById(borrowId);
    }
}
