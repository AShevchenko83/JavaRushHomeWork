package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Admin on 25.08.16.
 */
public class Tablet extends java.util.Observable
{
    private final int number;
    private static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number)
    {
        this.number = number;
    }

    public void createOrder(){
        Order order = null;
        try
        {
            order= new Order(this);
            if (!order.isEmpty())
            {

                ConsoleHelper.writeMessage(order.toString());
                new AdvertisementManager(order.getTotalCookingTime()*60).processVideos();
                setChanged();
                notifyObservers(order);

            }
        }
        catch (NoVideoAvailableException e)
        {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        catch (Exception e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }





    @Override
    public String toString()
    {
        return new String("Tablet{number="+number+"}");
    }
}
