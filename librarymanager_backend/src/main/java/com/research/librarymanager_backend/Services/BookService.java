package com.research.librarymanager_backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Exceptions.BookNotFoundException;
import com.research.librarymanager_backend.Models.Book;
import com.research.librarymanager_backend.Repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

   public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Create Book
    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    // get All Books
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    // Get Book by Id
    public Book getBookById(Long bookid){
        return bookRepository.findById(bookid).orElseThrow(()->new BookNotFoundException("Book with id"+ bookid +"Not Found"));
    }

    // Update Book
    public Book updateBook(Book book){
        return bookRepository.save(book);
    }

    // Delete Book
    public void deleteBook(Long bookId){
        bookRepository.deleteById(bookId);
    }

}
