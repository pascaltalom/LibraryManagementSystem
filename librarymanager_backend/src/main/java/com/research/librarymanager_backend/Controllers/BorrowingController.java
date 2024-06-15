package com.research.librarymanager_backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.librarymanager_backend.Models.Borrowing;
import com.research.librarymanager_backend.Services.BorrowingService;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Borrowing>> getAllBorrowings() {
        List<Borrowing> borrowing = borrowingService.getAllBorrowings();
        return new ResponseEntity<>(borrowing, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Borrowing> getBorrowingById(@PathVariable("id") Long id) {
        Borrowing borrowing = borrowingService.getBorrowingById(id);
        return new ResponseEntity<>(borrowing, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Borrowing> createBorrowing(@RequestBody Borrowing borrowing) {
        Borrowing newborrowing = borrowingService.createBorrowing(borrowing);
        return new ResponseEntity<>(newborrowing, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Borrowing> updateBorrowing(@RequestBody Borrowing borrowing) {
        Borrowing updatedBorrowing = borrowingService.updateBorrowing(borrowing);
        return new ResponseEntity<>(updatedBorrowing, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBorrowing(@PathVariable("id") Long id) {
        borrowingService.deleteBorrowing(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
