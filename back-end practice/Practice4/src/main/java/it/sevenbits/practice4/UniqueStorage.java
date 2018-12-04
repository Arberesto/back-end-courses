package it.sevenbits.practice4;

import java.util.HashSet;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Custom Set-like collection (can store only one unique object)
 * @param <T> type of stored elements
 */

public class UniqueStorage<T> implements IUniqueStorage<T> {
    private final Logger logger = LoggerFactory.getLogger(UniqueStorage.class);
    private HashSet<T> hashSet = new HashSet<T>();

    /**
     * Add element in storage
     * @param object object to add
     */

    public void add(final T object) {
        if (this.contains(object)) {
            logger.warn("Warning!Trying to add existing element!");
        }
        hashSet.add(object);
        logger.info("Object added");
    }

    /**
     * Remove object from storage
     * @param object object to remove
     */

    public void remove(final T object) {
        if (hashSet.contains(object)) {
            hashSet.remove(object);
            logger.info("Object removed");
        } else {
            logger.error("Error: try to remove non-existing element");
        }

    }

    /**
     *
     * @param object
     * @return
     */

    public boolean contains(final T object) {
        return hashSet.contains(object);
    }

    /**
     * Return iterator for storage
     * @return Iterator object
     */

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int counter = -1;
            private Object[] array = hashSet.toArray();

            @Override
            public boolean hasNext() {
                return counter < array.length;
            }

            @Override
            public T next() {
                counter++;
                return (T) array[counter];
            }

            @Override
            public void remove() {
                hashSet.remove(this.next());
            }
        };
    }
}
