package com.jwt.radis.exception;

import lombok.Getter;


@Getter
public class AssignmentRuntimeException extends RuntimeException {

    private ErrorCode errorCode;

    private String reason;

    public AssignmentRuntimeException(Throwable t){
        super(t);
    }

    public AssignmentRuntimeException(ErrorCode errorCode){
        this.errorCode = errorCode;
    }

    public AssignmentRuntimeException(ErrorCode errorCode, String reason){
        this.errorCode = errorCode;
        this.reason = reason;
    }
}
