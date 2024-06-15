package com.research.librarymanager_backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Models.Book;
import com.research.librarymanager_backend.Repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Create Book
    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    // get All Books
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    // Get Book by Id
    public Optional<Book>getBookById(Long id){
        return bookRepository.findById(id);
    }

    // Update Book
    public Book updateBook(Long bookId, Book book){
        Optional<Book> existingBook = bookRepository.findById(bookId);
        if(existingBook.isPresent()){
            Book updateBook = existingBook.get();
            updateBook.setTitle(book.getTitle());
            updateBook.setAuthor(book.getAuthor());
            updateBook.setIsbn(book.getIsbn());;
            updateBook.setGenre(book.getGenre());
            updateBook.setPublisher(book.getPublisher());
            updateBook.setPublishedDate(book.getPublishedDate());
            return bookRepository.save(updateBook);
        }
        return null;
    }

    // Delete Book
    public void deleteBook(Long Id){
        bookRepository.deleteById(Id);
    }


}
