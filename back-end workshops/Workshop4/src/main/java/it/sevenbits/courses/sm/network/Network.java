package it.sevenbits.courses.sm.network;


import java.util.concurrent.ConcurrentLinkedDeque;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Network implements INetwork {
    private final static Logger networkLogger = LoggerFactory.getLogger(Network.class);
    private final int maxSize;
    private ConcurrentLinkedDeque<NetworkPackage> packages = new ConcurrentLinkedDeque<NetworkPackage>();

    public Network(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean hasPackage() {
       return packages.size() > 0;
    }

    @Override
    public NetworkPackage getPackage(){
        NetworkPackage p = packages.removeFirst();
        if (networkLogger.isDebugEnabled()) {
            networkLogger.debug("Get package: %s",p.getType());
        }
        return p;
    }

    @Override
    public void addPackage(String message, String type) {
        if(packages.size() < maxSize) {
            NetworkPackage p = new NetworkPackage(type, message);
            if (networkLogger.isDebugEnabled()) {
                networkLogger.debug("Add package: %s with message %s",p.getType(), p.getMessage());
            }
            packages.addLast(p);
        }
        networkLogger.error("Network overloaded!");
    }
}
