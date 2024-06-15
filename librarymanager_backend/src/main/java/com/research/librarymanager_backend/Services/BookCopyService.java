package com.research.librarymanager_backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Exceptions.BookCopyNotFoundException;
import com.research.librarymanager_backend.Models.BookCopy;
import com.research.librarymanager_backend.Repositories.BookCopyRepository;

@Service
public class BookCopyService {

     @Autowired
    private BookCopyRepository bookcopyRepository;
    

    public BookCopyService(BookCopyRepository bookcopyRepository) {
        this.bookcopyRepository = bookcopyRepository;
    }

    // Create Book
    public BookCopy createBookCopy(BookCopy bookcopy){
        return bookcopyRepository.save(bookcopy);
    }

    // get All Books
    public List<BookCopy> getAllBookCopies(){
        return bookcopyRepository.findAll();
    }

    // Get Book by Id
    public BookCopy getBookCopyById(Long copyid){
        return bookcopyRepository.findById(copyid).orElseThrow(()->new BookCopyNotFoundException("BookCopy with id"+ copyid +"Not Found"));
    }

    // Update Book
    public BookCopy updateBookCopy(BookCopy bookcopy){
        return bookcopyRepository.save(bookcopy);
    }

    // Delete Book
    public void deleteBookCopy(Long copyId){
        bookcopyRepository.deleteById(copyId);
    }
}
