package it.sevenbits.practice5.Threads;

import it.sevenbits.practice5.Account.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadExecutor {
    private static Logger logger = LoggerFactory.getLogger(ThreadExecutor.class);
    public void showAccountFilling(long millis) {
        Account account = new Account(0);
        AccountThread thread1 = new AccountThread(account,10);
        AccountThread thread2 = new AccountThread(account,-5);
        AccountThread thread3 = new AccountThread(account, 3);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            return;
        }
        while (!(thread1.isInterrupted()&thread2.isInterrupted()&thread3.isInterrupted())) {
            thread1.interrupt();
            thread2.interrupt();
            thread3.interrupt();
        }
        try {
            Thread.sleep(100);
        }  catch (InterruptedException e) {
            logger.info("ThreadExecutor was interrupted");
        } finally {
            logger.info("Account status:");
            logger.info(account.toString());
        }

    }
}
