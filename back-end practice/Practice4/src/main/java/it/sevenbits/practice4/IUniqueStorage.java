package it.sevenbits.practice4;

/**
 * Interface for custom collection (can store one unique object)
 * @param <T> type of stored objects
 */

public interface IUniqueStorage<T> extends Iterable<T> {

    /**
     * Add element to storage
     */

    void add(T object);

    /**
     * Get element from storage
     * @return object of type T
     */

    void remove(T object);

    /**
     * Check if element already exist in storage
     * @return true if exist, else return false
     */

    boolean contains(T object);

}
