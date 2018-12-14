package it.sevenbits.courses.sm.manager.Command;

import it.sevenbits.courses.sm.manager.NetworkManagerContainer;
import it.sevenbits.courses.sm.sm.StateMachineNetworkManager;

public class AddToBufferCommand implements IAddToBufferCommand {
    private static NetworkManagerContainer container = StateMachineNetworkManager.getBuffer();

    public AddToBufferCommand() {
    }


    public void execute() {
        container.add();
    }
}
