package it.sevenbits.practice5;

import it.sevenbits.practice5.Account.Account;
import it.sevenbits.practice5.Threads.ThreadExecutor;
import it.sevenbits.practice5.listOperator.ListOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(Main.class);
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        LinkedList<Account> accountLinkedList = new LinkedList<Account>();
        integerArrayList.add(2);
        integerArrayList.add(5);
        integerArrayList.add(3);
        integerArrayList.add(12);

        accountLinkedList.add(new Account(2));
        accountLinkedList.add(new Account(0));
        accountLinkedList.add(new Account(15));
        accountLinkedList.add(new Account(3));
        accountLinkedList.add(new Account(400));

        ListOperator operator = new ListOperator();
        logger.info("Max in Integer ArrayList from 0 to 2 element:");
        logger.info(operator.max(integerArrayList, 0, 2).toString());
        logger.info("Max in Integer ArrayList from 1 to 3 element:");
        logger.info(operator.max(integerArrayList, 1, 3).toString());
        logger.info("Max in Account LinkedList from 0 to 2 element:");
        logger.info(operator.max(accountLinkedList, 0, 2).toString());
        logger.info("Max in Account LinkedList from 2 to 4 element:");
        logger.info(operator.max(accountLinkedList, 2, 4).toString());
        logger.info("Integer ArrayList before:");
        logger.info(integerArrayList.toString());
        logger.info("Switch 2 and 3 element in ArrayList:");
        operator.changeElementsPosition(integerArrayList, 2,3);
        logger.info("Integer ArrayList after:");
        logger.info(integerArrayList.toString());
        logger.info("Account LinkedList before:");
        logger.info(accountLinkedList.toString());
        logger.info("Switch 1 and 3 element in LinkedList:");
        operator.changeElementsPosition(accountLinkedList, 1,3);
        logger.info("Account LinkedList after:");
        logger.info(accountLinkedList.toString());

        ThreadExecutor threadExecutor = new ThreadExecutor();
        threadExecutor.showAccountFilling(3000);

    }

}
