package com.book.assignment.config;

import com.book.assignment.strategy.BookSalesStrategy;
import com.book.assignment.strategy.BookDiscountStrategy;
import com.book.assignment.strategy.BookDiscountStrategyImpl;
import com.book.assignment.strategy.SoldOut2018BookSalesStrategyImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
    @Bean
    public BookDiscountStrategy bookDiscountStrategy() {
        return new BookDiscountStrategyImpl();
    }

    @Bean
    public BookSalesStrategy bookSalesStrategy() {
        return new SoldOut2018BookSalesStrategyImpl();
    }
}
