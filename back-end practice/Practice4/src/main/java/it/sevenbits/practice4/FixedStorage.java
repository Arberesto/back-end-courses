package it.sevenbits.practice4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;

/**
 *Custom Map-like collection(store pair<key,value>)
 * @param <T>
 */

public class FixedStorage<T> implements IFixedStorage<T> {
    private HashMap<String, T> hashMap = new HashMap<>();
    private final int maxSize;
    private final Logger logger = LoggerFactory.getLogger(FixedStorage.class);

    /**
     * constructor of class
     * @param size max size of storage
     */

    FixedStorage(final int size) {
        maxSize = size;
    }

    /**
     * Add new element to storage
     * @param key key of new element
     * @param value value of new element
     */

    public void add(final String key, final T value) {
        if (hashMap.size() < maxSize) {
            if (hashMap.containsKey(key)) {
                logger.warn("Warning: rewrite existing element");
                hashMap.replace(key, value);
            }
            hashMap.put(key, value);
            logger.info("Add new element");
        } else {
            logger.error("Error: can't add new element, max size of storage reached. " +
                    "Lost element: key - " + key + "; value - " + value.toString());
        }
    }

    /**
     *Remove element from storage if it exist
     * @param key key of removed element
     */

    public void remove(final String key) {
        if (hashMap.remove(key) != null) {
            logger.info("Remove element");
        } else {
            logger.error("Error: trying to remove non-existing element");
        }
    }

    /**
     * Get value of storage's element by key
     * @param key key of pair<key,value> stored in storage
     * @return value of found element if it exist or null
     */

    public T get(final String key) {
        return hashMap.get(key);
    }

    /**
     *Check if storage contain pair with offered value
     * @param value value to check
     * @return true if contain, else return false
     */

    public boolean contains(final T value) {
        return hashMap.containsValue(value);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int counter = -1;
            private Object[] keySet = hashMap.keySet().toArray();

            @Override
            public boolean hasNext() {
                return counter + 1 < keySet.length;
            }

            @Override
            public T next() {
                counter++;
                logger.info("Get element with iterator");
                return hashMap.get((String) keySet[counter]);

            }

            @Override
            public void remove() {
                T result = hashMap.remove((String) keySet[counter]);
                if (result != null) {
                    logger.info("Remove element with iterator");
                } else {
                    logger.error("Error: try to remove non-existing element with iterator");
                }
            }
        };
    }
}
