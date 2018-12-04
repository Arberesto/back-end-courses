package it.sevenbits.practice4;

public interface IFixedStorage<T> extends Iterable<T> {
    void add(String key, T value);
    void remove(String key);
    T get(String key);
    boolean contains(T value);
}
