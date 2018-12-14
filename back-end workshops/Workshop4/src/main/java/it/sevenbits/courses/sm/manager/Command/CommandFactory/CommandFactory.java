package it.sevenbits.courses.sm.manager.Command.CommandFactory;

import it.sevenbits.courses.sm.manager.Command.*;
import it.sevenbits.courses.sm.network.NetworkPackage;
import it.sevenbits.courses.sm.sm.Pair;
import it.sevenbits.courses.sm.sm.State;

import java.util.HashMap;

public class CommandFactory implements ICommandFactory {

    private HashMap<Pair<String, State>, INetworkManagerCommand> hashMap;
    private final INetworkManagerCommand ignoreCommand = new IgnoreCommand();

    public CommandFactory() {
        this.hashMap = new HashMap<>();
        final INetworkManagerCommand addToBufferCommand = new AddToBufferCommand();
        final INetworkManagerCommand writeAndClearCommand = new WriteAndClearCommand();
        hashMap.put(new Pair<>("MESSAGE", new State("LISTEN")), addToBufferCommand);
        hashMap.put(new Pair<>("MESSAGE", new State("IGNORE")), ignoreCommand);
        hashMap.put(new Pair<>("MESSAGE", new State("TRASH_SUSPICION")), addToBufferCommand);
        hashMap.put(new Pair<>("TRASH", new State("LISTEN")), ignoreCommand);
        hashMap.put(new Pair<>("TRASH", new State("IGNORE")), ignoreCommand);
        hashMap.put(new Pair<>("TRASH", new State("TRASH_SUSPICION")), writeAndClearCommand);
        hashMap.put(new Pair<>("MESSAGE_START", new State("LISTEN")), ignoreCommand);
        hashMap.put(new Pair<>("MESSAGE_START", new State("IGNORE")), ignoreCommand);
        hashMap.put(new Pair<>("MESSAGE_START", new State("TRASH_SUSPICION")), ignoreCommand);
        hashMap.put(new Pair<>("MESSAGE_FINISH", new State("LISTEN")), writeAndClearCommand);
        hashMap.put(new Pair<>("MESSAGE_FINISH", new State("IGNORE")), ignoreCommand);
        hashMap.put(new Pair<>("MESSAGE_FINISH", new State("TRASH_SUSPICION")), writeAndClearCommand);
    }

    public INetworkManagerCommand getCommand(NetworkPackage p, State state) {
        return hashMap.getOrDefault(new Pair<>(p.getType(), state), ignoreCommand);
    }
}
