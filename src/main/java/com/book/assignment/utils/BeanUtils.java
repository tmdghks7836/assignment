package com.book.assignment.utils;

import com.book.assignment.provider.ApplicationContextProvider;
import org.springframework.context.ApplicationContext;

public class BeanUtils {
    public static <T> T getBean(Class<T> classType) {
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        return applicationContext.getBean(classType);
    }
}
