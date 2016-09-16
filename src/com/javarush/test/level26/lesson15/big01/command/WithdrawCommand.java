package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Admin on 18.08.16.
 */
class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        CurrencyManipulator manip = null;
        String code=null;
        while (true)
        {
            try
            {
                code= ConsoleHelper.askCurrencyCode();
                manip = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
                break;
            }
            catch (Exception e)
            {

            }
        }
        int summa = 0;
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            while (true){

                try
                {
                    int enter = Integer.parseInt(ConsoleHelper.readString());
                    if(enter>0) {
                        summa = enter;
                        break;
                    }
                    else throw new NumberFormatException();
                }
                catch (NumberFormatException e)
                {
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                }

            }
            try
            {
                Map<Integer, Integer> map= manip.withdrawAmount(summa);
                ArrayList<Integer> nomins= new ArrayList<>(map.keySet());
                Collections.sort(nomins);
                int withdraw=0;
                for (int i = nomins.size()-1; i >=0 ; i--)
                {
                    System.out.println("\t"+nomins.get(i)+" - "+ map.get(Integer.valueOf(nomins.get(i))));
                    withdraw +=nomins.get(i)*map.get(nomins.get(i));
                }
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), withdraw,code));
                break;
            }
            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            }
            catch (RuntimeException e)
            {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }
        }

    }
}
