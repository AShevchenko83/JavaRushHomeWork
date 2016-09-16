package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Admin on 21.08.16.
 */
public class LoginCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        ConsoleHelper.writeMessage(res.getString("specify.data"));
        while (true)
        {
            try
            {
                ConsoleHelper.writeMessage("Enter Login");
                String number = ConsoleHelper.readString();
                ConsoleHelper.writeMessage("Enter Pin");
                String pin = ConsoleHelper.readString();

                if(validCreditCards.containsKey(number)){
                    if (validCreditCards.getString(number).equals(pin)){
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"),number));
                        break;
                    }
                }
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"),number));
                throw new NumberFormatException();
            }
            catch (Exception e)
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
            }


        }
    }
}
