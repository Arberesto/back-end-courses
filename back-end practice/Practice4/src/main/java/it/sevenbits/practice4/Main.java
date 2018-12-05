package it.sevenbits.practice4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Start point of program
 */

public final class Main {

    private Main(){}

    /**
     * start method
     * @param args arguments in cmd(args[0] - size of fixedStorage)
     */

    public static void main(final String[] args) {
        int sizeNumber = Integer.parseInt(args[0]);
        final Logger logger = LoggerFactory.getLogger(Main.class);
        UniqueStorage<Planet> uniqueStorage = new UniqueStorage<>();
        FixedStorage<Planet> fixedStorage = new FixedStorage<>(sizeNumber);

        Planet planet = new Planet("Mercury");
        fixedStorage.add(planet.getId(), planet);
        uniqueStorage.add(planet);
        planet = new Planet("Venus");
        fixedStorage.add(planet.getId(), planet);
        uniqueStorage.add(planet);
        planet = new Planet("Earth");
        fixedStorage.add(planet.getId(), planet);
        fixedStorage.add(planet.getId(), planet);
        uniqueStorage.add(planet);
        planet = new Planet("Mars");
        fixedStorage.add(planet.getId(), planet);
        uniqueStorage.add(planet);
        uniqueStorage.add(planet);
        planet = new Planet("Jupiter");
        fixedStorage.add(planet.getId(), planet);
        uniqueStorage.add(planet);
        planet = new Planet("Saturn");
        fixedStorage.add(planet.getId(), planet);
        uniqueStorage.add(planet);
        planet = new Planet("Uranus");
        fixedStorage.add(planet.getId(), planet);
        fixedStorage.remove(planet.getId());
        fixedStorage.add(planet.getId(), planet);
        uniqueStorage.add(planet);

        planet = new Planet("Neptune");
        fixedStorage.add(planet.getId(), planet);
        uniqueStorage.add(planet);
        uniqueStorage.remove(planet);

        for (Planet i: fixedStorage) {
            if (uniqueStorage.contains(i)) {
                logger.info("Object with name " + i.getName() + " exist in both storages");
            }
        }
    }
}
