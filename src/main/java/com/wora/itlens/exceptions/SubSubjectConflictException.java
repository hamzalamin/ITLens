package com.wora.itlens.exceptions;

public class SubSubjectConflictException extends RuntimeException {
    public SubSubjectConflictException(String message) {
        super(message);
    }

  public SubSubjectConflictException(String message, Throwable cause) {
    super(message, cause);
  }
}
