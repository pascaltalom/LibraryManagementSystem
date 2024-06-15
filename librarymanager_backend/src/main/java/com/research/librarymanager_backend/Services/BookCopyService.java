package com.research.librarymanager_backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Models.BookCopy;
import com.research.librarymanager_backend.Repositories.BookCopyRepository;

@Service
public class BookCopyService {

     @Autowired
    private BookCopyRepository bookcopyRepository;

    // Create Book
    public BookCopy createBookCopy(BookCopy bookcopy){
        return bookcopyRepository.save(bookcopy);
    }

    // get All Books
    public List<BookCopy> getAllBookCopies(){
        return bookcopyRepository.findAll();
    }

    // Get Book by Id
    public Optional<BookCopy>getBookCopyById(Long id){
        return bookcopyRepository.findById(id);
    }

    // Update Book
    public BookCopy updateBook(Long CopyId, BookCopy bookcopy){
        Optional<BookCopy> existingBookCopy = bookcopyRepository.findById(CopyId);
        if(existingBookCopy.isPresent()){
            BookCopy updateBookCopy = existingBookCopy.get();
            updateBookCopy.setBook(bookcopy.getBook());
            updateBookCopy.setStatus(bookcopy.getStatus());
            updateBookCopy.setDueDate(bookcopy.getDueDate());
            return bookcopyRepository.save(updateBookCopy);
        }
        return null;
    }

    // Delete Book
    public void deleteBookCopy(Long copyId){
        bookcopyRepository.deleteById(copyId);
    }
}
