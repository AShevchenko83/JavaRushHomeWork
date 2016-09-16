package com.javarush.test.level14.lesson08.home05;

import javax.management.MalformedObjectNameException;

/**
 * Created by Admin on 19.05.16.
 */
public class Computer
{
    private Keyboard keyboard=null;
    private Mouse mouse= null;
    private Monitor monitor = null;

    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }

    public Computer()
    {
        keyboard = new Keyboard();
        monitor= new Monitor();
        mouse = new Mouse();

    }
}
