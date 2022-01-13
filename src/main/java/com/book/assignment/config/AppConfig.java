package com.book.assignment.config;

import com.book.assignment.strategy.DiscountStrategy;
import com.book.assignment.strategy.BookDiscountStrategyImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
    @Bean
    public DiscountStrategy bookDiscountStrategy() {
        return new BookDiscountStrategyImpl();
    }
}
