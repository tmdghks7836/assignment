package com.book.assignment;

import com.book.assignment.model.dto.book.BookCreationRequest;
import com.book.assignment.model.dto.book.BookResponse;
import com.book.assignment.model.entity.Contractor;
import com.book.assignment.model.type.BookType;
import com.book.assignment.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional(readOnly = true)
class MainApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    @Transactional
    void test1() {

        BookCreationRequest bookCreationRequest = BookCreationRequest.builder()
                .amount(10000l)
                .author("이승환 저자")
                .bookType(BookType.GUN)
                .discountRate(10f)
                .issueDate(LocalDateTime.now())
                .name("이것은 책이다.")
                .regularPrice(10000l)
                .supplyPrice(12000l)
                .build();

        long bookId = bookService.create(bookCreationRequest);

        BookResponse bookResponse = bookService.get(bookId);

        assert bookResponse.getName().equals("이것은 책이다.");

        //계약업체
//        Contractor contractor = new Contractor(10f, LocalDateTime.now().plusDays(1));

    }

}
