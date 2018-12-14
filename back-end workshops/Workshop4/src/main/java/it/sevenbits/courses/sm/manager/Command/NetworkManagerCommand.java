package it.sevenbits.courses.sm.manager.Command;

import it.sevenbits.courses.sm.sm.StateMachineNetworkManager;

import java.util.ArrayList;

public class NetworkManagerCommand implements  INetworkManagerCommand {

    private static StringBuffer sb = StateMachineNetworkManager.getBuffer();
    private final ArrayList<String> commandList;

    public NetworkManagerCommand(ArrayList<String> arrayList) {
        this.commandList = arrayList;
    }


    public void execute() {
        for (String command : commandList) {

        }
    }
}
