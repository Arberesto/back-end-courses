package it.sevenbits.courses.sm.log;

import it.sevenbits.courses.sm.network.NetworkPackage;

public class MessageFormatter {
    private MessageTransition messageTransition;

    public MessageFormatter() {
        messageTransition = new MessageTransition();
    }

    public String getStringFormatByType(NetworkPackage p){
        return messageTransition.getMessage(p.getType(),p.getMessage());
    }
}
