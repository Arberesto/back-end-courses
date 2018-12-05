package it.sevenbits.practice4;

/**
 *Interface for custom collection(store pair<key,value>)
 * @param <T>
 */

public interface IFixedStorage<T> extends Iterable<T> {

    /**
     * Add new element to storage
     * @param key key of new element
     * @param value value of new element
     */

    void add(String key, T value);

    /**
     *Remove element from storage if it exist
     * @param key key of removed element
     */

    void remove(String key);

    /**
     * Get value of storage's element by key
     * @param key key of pair<key,value> stored in storage
     * @return value of found element if it exist or null
     */

    T get(String key);

    /**
     *Check if storage contain pair with offered value
     * @param value value to check
     * @return true if contain, else return false
     */

    boolean contains(T value);
}
