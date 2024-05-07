package ru.edu.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.edu.springdata.entity.Book;
import ru.edu.springdata.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    public BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return repository.findById(id);
    }

    public Book saveBook(Book book) {
        return repository.findById(repository.save(book).getId())
                .orElseThrow(() -> new RuntimeException("Book is not found."));
    }

    public List<Book> findByCategory(String category) {
        return repository.findBooksByCategory(category);
    }
    public List<Book> findByLanguage(String language) {
        return repository.findBooksByLanguage(language);
    }

    public List<Book> getAllByLanguageAndCategory(String category, String language) {
        return repository.findBooksByCategoryAndLanguage(category, language);
    }

    public void deleteBookById(Long id) {
        repository.deleteById(id);
    }

}
