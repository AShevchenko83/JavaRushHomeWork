package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Admin on 20.05.16.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }

    public String getCurrencyName()
    {
        return "USD";
    }
}
