package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Admin on 26.08.16.
 */
public class Cook extends Observable implements Observer
{
    private String name;
    private Observable tablet;


    public Cook(String name)
    {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        Order order= (Order) arg;
        tablet=o;
        ConsoleHelper.writeMessage("Start cooking - "+order+", cooking time "+
                order.getTotalCookingTime()+"min");

        setChanged();
        notifyObservers(order);


    }

    @Override
    public String toString()
    {
        return name;
    }
}
