package ru.edu.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.springdata.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByCategory(String category);
    List<Book> findBooksByLanguage(String language);
    List<Book> findBooksByCategoryAndLanguage(String category, String language);
}
