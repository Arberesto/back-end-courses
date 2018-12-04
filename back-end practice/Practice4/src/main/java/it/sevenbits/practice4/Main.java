package it.sevenbits.practice4;

/**
 * Start point of program
 */

public final class Main {

    private Main(){}

    /**
     * start method
     * @param args arguments in cmd(not used)
     */

    public static void main(final String[] args) {
        UniqueStorage<Planet> uniqueStorage = new UniqueStorage<>();
        FixedStorage<Planet> fixedStorage = new FixedStorage<>();
        uniqueStorage.add(new Planet("Mercury"));
        uniqueStorage.add(new Planet("Venus"));
        uniqueStorage.add(new Planet("Earth"));
        uniqueStorage.add(new Planet("Mars"));
        uniqueStorage.add(new Planet("Jupiter"));
        uniqueStorage.add(new Planet("Saturn"));
        uniqueStorage.add(new Planet("Uranus"));

        fixedStorage.add("Mercury", new Planet("Mercury"));
        fixedStorage.add("Venus", new Planet("Venus"));
        fixedStorage.add("Earth", new Planet("Earth"));
        fixedStorage.add("Mars", new Planet("Mars"));
        fixedStorage.add("Jupiter", new Planet("Jupiter"));
        fixedStorage.add("Saturn", new Planet("Saturn"));
        fixedStorage.add("Uranus", new Planet("Uranus"));
    }
}
