package it.sevenbits.courses.sm.log;

import it.sevenbits.courses.sm.sm.State;

import java.util.HashMap;
import java.util.Map;

public class MessageMap {
    private final State defaultState = new State("Unknown package type");
    private final Map<String, State> messages;

    public MessageMap() {
        this.messages = new HashMap<>();
        State messageState = new State("Part of message: ");
        State trashState = new State("Trash received");
        State startState = new State("Message creating started");
        State finishState = new State("Message creating finished");
        this.messages.put("MESSAGE",messageState);
        this.messages.put("TRASH",trashState);
        this.messages.put("MESSAGE_START",startState);
        this.messages.put("MESSAGE_FINISH",finishState);
    }

    public State getNextMessage(String type) {
        return this.messages.getOrDefault(type, defaultState);
    }

}
