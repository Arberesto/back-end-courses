package it.sevenbits.courses.sm.manager.Command;

import it.sevenbits.courses.sm.manager.NetworkManagerContainer;
import it.sevenbits.courses.sm.sm.StateMachineNetworkManager;

public class WriteAndClearCommand implements IWriteAndClearCommand{
    private static NetworkManagerContainer container = StateMachineNetworkManager.getBuffer();

    public WriteAndClearCommand() {
    }


    public void execute() {
        container.writeInConsole();
        container.clearBuffer();
    }
}
