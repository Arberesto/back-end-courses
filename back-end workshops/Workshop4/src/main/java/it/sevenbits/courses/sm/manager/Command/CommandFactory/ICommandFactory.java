package it.sevenbits.courses.sm.manager.Command.CommandFactory;

import it.sevenbits.courses.sm.manager.Command.INetworkManagerCommand;
import it.sevenbits.courses.sm.network.NetworkPackage;
import it.sevenbits.courses.sm.sm.State;

public interface ICommandFactory {

    INetworkManagerCommand getCommand(NetworkPackage p, State state);
}
