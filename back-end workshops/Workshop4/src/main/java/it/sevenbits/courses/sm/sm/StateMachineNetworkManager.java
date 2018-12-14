package it.sevenbits.courses.sm.sm;

import it.sevenbits.courses.sm.log.MessageFormatter;
import it.sevenbits.courses.sm.manager.Command.CommandFactory.CommandFactory;
import it.sevenbits.courses.sm.manager.INetworkManager;
import it.sevenbits.courses.sm.manager.NetworkManagerContainer;
import it.sevenbits.courses.sm.manager.NetworkManagerException;
import it.sevenbits.courses.sm.network.INetwork;
import it.sevenbits.courses.sm.network.NetworkPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StateMachineNetworkManager implements INetworkManager {
    private final static Logger logger = LoggerFactory.getLogger(StateMachineNetworkManager.class);
    private boolean isInterrupted = false;
    private CommandFactory commandFactory;
    private final long TIMEOUT = 500;
    private final StateTransition stateTransition;
    private final MessageFormatter messageFormatter;
    private final static NetworkManagerContainer container = new NetworkManagerContainer();

    public StateMachineNetworkManager() {
        this.stateTransition = new StateTransition();
        this.messageFormatter = new MessageFormatter();
        this.commandFactory = new CommandFactory();
    }

    public static NetworkManagerContainer getBuffer() {
        return  container;
    }

    @Override
    public void listen(INetwork network) throws NetworkManagerException {
        State currentState = stateTransition.getStartState();
        try {
            while(!isInterrupted){
                while(network.hasPackage()){
                    NetworkPackage p = network.getPackage();
                    container.addNewMessage(p.getMessage());
                    logger.info(messageFormatter.getStringFormatByType(p));
                    commandFactory.getCommand(p, currentState).execute();
                    currentState = stateTransition.nextState(currentState, p);
                }
                Thread.sleep(TIMEOUT);
            }
        } catch (InterruptedException e){
            logger.error("Network manager was interrupted unexpectedly");
            throw new NetworkManagerException("Network manager was interrupted unexpectedly", e);
        }
    }

    @Override
    public void stop() {
        logger.info("Finish listening");
        isInterrupted = true;
    }
}