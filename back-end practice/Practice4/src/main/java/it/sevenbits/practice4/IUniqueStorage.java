package it.sevenbits.practice4;

/**
 * Interface for custom collection (can store one unique object)
 * @param <T> type of stored objects
 */

public interface IUniqueStorage<T> extends Iterable<T> {

    /**
     * Add element to storage
     * @param object element to add
     */

    void add(T object);

    /**
     * Remove element from storage
     * @param object element to remove
     */

    void remove(T object);

    /**
     * Check if element already exist in storage
     * @param object checked element
     * @return true if exist, else return false
     */

    boolean contains(T object);

}
