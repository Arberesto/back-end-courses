package com.ten_experts.Summatra.array;

public class ArraySummaterException extends Exception {
    public ArraySummaterException(final String message) {
        super(message);
    }

    public ArraySummaterException(final String message, final Exception e) {
        super(message, e);
    }
}
