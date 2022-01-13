package com.book.assignment.repository;

import com.book.assignment.model.entity.Book;
import com.book.assignment.repository.support.custom.BookRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom {

}
