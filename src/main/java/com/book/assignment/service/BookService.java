package com.book.assignment.service;

import com.book.assignment.exception.CustomRuntimeException;
import com.book.assignment.exception.ErrorCode;
import com.book.assignment.exception.ResourceNotFoundException;
import com.book.assignment.model.dto.book.BookCreationRequest;
import com.book.assignment.model.dto.book.BookResponse;
import com.book.assignment.model.dto.book.BookUpdateRequest;
import com.book.assignment.model.entity.Book;
import com.book.assignment.model.mapper.BookMapper;
import com.book.assignment.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * @return bookId
     */
    @Transactional
    public long create(BookCreationRequest bookCreationRequest) {

        Book book = BookMapper.INSTANCE.dtoToEntity(bookCreationRequest);

        bookRepository.save(book);

        return book.getId();
    }

    public Page<BookResponse> getList(Pageable pageable) {
        Page<Book> bookPage = bookRepository.findAll(pageable);

        return bookPage.map(book -> BookMapper.INSTANCE.entityToDto(book));
    }

    public BookResponse get(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() ->
                new ResourceNotFoundException());

        return BookMapper.INSTANCE.entityToDto(book);
    }

    @Transactional
    public void update(Long bookId, BookUpdateRequest bookUpdateRequest) {

        Book book = bookRepository.findById(bookId).orElseThrow(() ->
                new ResourceNotFoundException());

        book.update(bookUpdateRequest);
    }
}
