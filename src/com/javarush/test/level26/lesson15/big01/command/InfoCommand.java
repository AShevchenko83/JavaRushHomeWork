package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

/**
 * Created by Admin on 18.08.16.
 */
class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");
    @Override
    public void execute()
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        int epmtyManip=0;
        for (CurrencyManipulator manip: CurrencyManipulatorFactory.getAllCurrencyManipulators()             )
        {
            if(manip.hasMoney())
            System.out.println(manip.getCurrencyCode()+" - "+manip.getTotalAmount());
            else epmtyManip++;
        }
        if (epmtyManip==CurrencyManipulatorFactory.getAllCurrencyManipulators().size()){
            ConsoleHelper.writeMessage(res.getString("no.money"));

        }
    }
}
