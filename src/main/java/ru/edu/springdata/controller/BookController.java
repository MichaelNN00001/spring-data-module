package ru.edu.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.edu.springdata.dto.BookRequestByCategoryAndLanguage;
import ru.edu.springdata.entity.Book;
import ru.edu.springdata.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> findAll() {
        return bookService.getAllBooks();
    }

    @PostMapping(value = "/add")
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/get/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id).orElseThrow(() -> new RuntimeException("Book is not found"));
    }

    @PatchMapping(value = "/update")
    public void updateBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

    @PostMapping(value = "/getByLanguage/{language}")
    public List<Book> getByLanguage(@PathVariable String language) {
        return bookService.findByLanguage(language);
    }

    @PostMapping(value = "/getByCategory/{category}")
    public List<Book> getByCategory(@PathVariable String category) {
        return bookService.findByCategory(category);
    }

    @PostMapping("/getByLang&Cat")
    public List<Book>  getByLanguageAndCategory(@RequestBody BookRequestByCategoryAndLanguage request) {
        return bookService.getAllByLanguageAndCategory(request.getCategory(), request.getLanguage());
    }
}