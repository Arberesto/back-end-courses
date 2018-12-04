package it.sevenbits.practice4;

import java.util.UUID;

/**
 * Some planet class
 */

public class Planet {
    private String name;
    private String id;

    /**
     * Create new planet
     * @param name name of new planet
     */

    public Planet(final String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }
}
