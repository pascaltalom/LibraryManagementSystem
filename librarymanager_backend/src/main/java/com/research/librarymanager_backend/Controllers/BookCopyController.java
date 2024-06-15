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

import com.research.librarymanager_backend.Models.BookCopy;
import com.research.librarymanager_backend.Services.BookCopyService;

@RestController
@RequestMapping("/api/bookcopies")
public class BookCopyController {

    @Autowired
    private BookCopyService bookCopyService;

    public BookCopyController(BookCopyService bookCopyService) {
        this.bookCopyService = bookCopyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookCopy>> getAllBookCopies() {
        List<BookCopy> bookcopy =bookCopyService.getAllBookCopies();
        return new ResponseEntity<>(bookcopy, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<BookCopy> getBookCopyById(@PathVariable("id") Long id) {
        BookCopy bookcopy = bookCopyService.getBookCopyById(id);
        return new ResponseEntity<>(bookcopy, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<BookCopy> createBookCopy(@RequestBody BookCopy bookCopy) {
        BookCopy newbookcopy = bookCopyService.createBookCopy(bookCopy);
        return new ResponseEntity<>(newbookcopy, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<BookCopy> updateBookCopy(@RequestBody BookCopy bookCopy) {
        BookCopy updatebookcopy = bookCopyService.updateBookCopy(bookCopy);
        return new ResponseEntity<>(updatebookcopy, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBookCopy(@PathVariable("id") Long id) {
        bookCopyService.deleteBookCopy(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}