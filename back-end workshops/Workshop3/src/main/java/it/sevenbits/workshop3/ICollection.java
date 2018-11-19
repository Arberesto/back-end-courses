package it.sevenbits.workshop3;

import java.io.IOException;

public interface ICollection {
    void add(User user) throws IOException;
    User get(long index) throws IOException;
}