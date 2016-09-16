package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 18.08.16.
 */
public class CommandExecutor
{
    private static Map<Operation, Command> mapOpation = new HashMap<>();

    static {
        mapOpation.put(Operation.LOGIN, new LoginCommand());
        mapOpation.put(Operation.DEPOSIT, new DepositCommand());
        mapOpation.put(Operation.EXIT, new ExitCommand());
        mapOpation.put(Operation.WITHDRAW, new WithdrawCommand());
        mapOpation.put(Operation.INFO, new InfoCommand());
    }

    public static final void execute(Operation operation) throws InterruptOperationException{
        mapOpation.get(operation).execute();
    }

    private CommandExecutor()
    {
    }
}
