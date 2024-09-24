package com.example.librarymanagement.librarymanagement.service;
import com.example.librarymanagement.librarymanagement.bookDTO.BookDTO;
import com.example.librarymanagement.librarymanagement.entity.Book;
import com.example.librarymanagement.librarymanagement.exceptions.ResourceNotFoundException;
import com.example.librarymanagement.librarymanagement.repository.BookRepository;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {


    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Convert Book entity to BookDTO
    private BookDTO convertEntityToDTO(Book book) {
        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(),book.getRating(),book.getTheme());
    }

    // Convert BookDTO to Book entity
    private Book convertDTOToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setTheme(bookDTO.getTheme());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setRating((bookDTO.getRating()));
        return book;
    }

    // Add a new book
    public BookDTO addBook(BookDTO bookDTO) {
        Book book = convertDTOToEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        return convertEntityToDTO(savedBook);
    }

    // Get all books
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    boolean isExistById(Long id){
        boolean isExist = bookRepository.existsById(id);
        if(!isExist) throw new ResourceNotFoundException("Resource Not found");
        return true;
    }

    // Get book by id

    public Optional<BookDTO> getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(this::convertEntityToDTO);
    }

    // Delete book by id
    public void deleteBookById(Long id) {
        if(!isExistById(id));
        bookRepository.deleteById(id);
    }
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        if(!isExistById(id));
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (bookDTO.getTitle() != null) {
                book.setTitle(bookDTO.getTitle());
            }
            if(bookDTO.getTheme()!=null){
                book.setTheme(bookDTO.getTheme());
            }
            if (bookDTO.getAuthor() != null) {
                book.setAuthor(bookDTO.getAuthor());
            }
            if (bookDTO.getIsbn() != null) {
                book.setIsbn(bookDTO.getIsbn());
            }
            if(bookDTO.getRating()!=null){
                book.setRating(bookDTO.getRating());
            }
            Book updatedBook = bookRepository.save(book);
            return convertEntityToDTO(updatedBook);
        }
        return null; // Return null if book with the given ID is not found
    }


    public BookDTO updateBookFully(Long id, BookDTO bookDTO) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            // Replace the entire entity with the new values from BookDTO
            book.setTitle(bookDTO.getTitle());
            book.setAuthor(bookDTO.getAuthor());
            book.setIsbn(bookDTO.getIsbn());
            book.setRating(bookDTO.getRating());
            book.setTheme(bookDTO.getTheme());
            Book updatedBook = bookRepository.save(book);
            return convertEntityToDTO(updatedBook);
        }
        return null; // Return null if the book with the given ID is not found
    }
}