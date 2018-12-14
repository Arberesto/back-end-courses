package it.sevenbits.courses.sm.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetworkManagerContainer implements  INetworkManagerContainer {
    private final static Logger logger = LoggerFactory.getLogger(NetworkManagerContainer.class);
    private static StringBuilder str = new StringBuilder();
    private static String lastMessage;

    public void addNewMessage(String newMessage) {
        lastMessage = newMessage;
    }
    public void add() {
        str.append(lastMessage);
    }

    public void writeInConsole() {
        logger.info(str.toString());
    }

    public void clearBuffer () {
        str = new StringBuilder();
    }
}
