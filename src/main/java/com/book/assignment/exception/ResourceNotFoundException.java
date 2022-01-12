package com.book.assignment.exception;

import lombok.Getter;


@Getter
public class ResourceNotFoundException extends CustomRuntimeException {

    public ResourceNotFoundException() {
        super(ErrorCode.RESOURCE_NOT_FOUND);
    }
}
