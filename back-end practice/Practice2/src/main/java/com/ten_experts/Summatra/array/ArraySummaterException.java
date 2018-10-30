package com.ten_experts.Summatra.array;

class ArraySummaterException extends Exception {
    ArraySummaterException(final String message) {
        super(message);
    }

// check-style ругается на неиспользуемый конструктор, но стоит оставить такой вариант на случай сложных исключений.

    ArraySummaterException(final String message, final Exception e) {
        super(message, e);
    }
}
