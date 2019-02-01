package it.sevenbits.practice5.Threads;

import it.sevenbits.practice5.Account.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountThread extends Thread {
    private Account account;
    private long value;
    private static Logger logger = LoggerFactory.getLogger(AccountThread.class);
    public AccountThread(Account account, long value) {
        this.account = account;
        this.value = value;
    }

    @Override
    public void run() {
        logger.info(String.format("%s started",Thread.currentThread().getName()));
        try {
            while (!isInterrupted()) {
                try {
                    synchronized (account) {
                        account.addToBalance(value);
                    }
                } catch (Exception e) {
                    logger.info(String.format("%s catch exception in addToBalance method",
                            Thread.currentThread().getName()));
                }
                Thread.sleep(10);
                // logger.info(String.format("%s working",Thread.currentThread().getName()));
            }
        } catch (InterruptedException e) {
            logger.info(String.format("%s interrupted",Thread.currentThread().getName()));
            return;
        }
        logger.info(String.format("%s finished",Thread.currentThread().getName()));
    }
}
