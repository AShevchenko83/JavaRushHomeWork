package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Admin on 26.08.16.
 */
public class Waitor implements Observer
{
    private Observable cook;
    @Override
    public void update(Observable o, Object arg)
    {
        cook=o;
        ConsoleHelper.writeMessage(arg + " was cooked by " + cook);
    }
}
