package it.sevenbits.workshop3;

public class UserManagerException extends Exception {
    public UserManagerException(String s) {
        super(s);
    }

    public UserManagerException(String message, Throwable cause) {
        super(message, cause);
    }
}
