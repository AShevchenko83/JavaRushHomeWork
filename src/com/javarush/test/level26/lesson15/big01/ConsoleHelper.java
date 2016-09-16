package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * Created by Admin on 15.08.16.
 */
public class ConsoleHelper
{
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString()throws InterruptOperationException{
        String str = new String();
        try
        {
            str= reader.readLine();

        }
        catch (IOException e) {}
        if(str.toUpperCase().equals("EXIT")){
            writeMessage(res.getString("the.end"));
            throw new InterruptOperationException();
        }
        return  str;
    }

    public static String askCurrencyCode()throws InterruptOperationException{


            writeMessage(res.getString("choose.currency.code"));
            String str = readString();
            if(str.length()==3) return str.toUpperCase();
            else throw new RuntimeException();


    }

    public static String[] getValidTwoDigits(String currencyCode)throws InterruptOperationException{

            writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
            String[] split = readString().split(" ");
                if(split.length!=2) throw new NumberFormatException();
                int nom = Integer.parseInt(split[0]);
                int count  =Integer.parseInt(split[1]);

                if(nom<=0||count<=0) throw new NumberFormatException();
                return split;
    }

    public static Operation askOperation()throws InterruptOperationException{
        while (true){
            try
            {
                writeMessage(res.getString("choose.operation"));
                writeMessage("Enter operation code: 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT ");
                String str = readString();
                int code = Integer.parseInt(str);
                Operation op = Operation.getAllowableOperationByOrdinal(code);
                return op;
            }
            catch (Exception e)
            {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

}
