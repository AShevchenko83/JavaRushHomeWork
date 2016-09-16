package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Admin on 18.08.16.
 */
class DepositCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");
    @Override
    public void execute() throws InterruptOperationException
    {
            ConsoleHelper.writeMessage(res.getString("before"));
        String code = null;
        while (true)
        {
            try
            {
                code = ConsoleHelper.askCurrencyCode();
                break;
            }
            catch (RuntimeException e)
            {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
        CurrencyManipulator manip = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        String[] values = new String[0];
        while (true)
        {
            try
            {
                values = ConsoleHelper.getValidTwoDigits(code);
                break;
            }
            catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
        manip.addAmount(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), Integer.parseInt(values[0])*Integer.parseInt(values[1]),code) );

    }
}
