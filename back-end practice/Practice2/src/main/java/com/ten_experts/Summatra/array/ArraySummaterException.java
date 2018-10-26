package com.ten_experts.Summatra.array;

class ArraySummaterException extends Exception {
    ArraySummaterException(final String message) {
        super(message);
    }

    ArraySummaterException(final String message, final Exception e) {
        super(message, e);
    }
}
