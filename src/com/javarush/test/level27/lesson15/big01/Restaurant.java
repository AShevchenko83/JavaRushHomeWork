package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.Observable;

/**
 * Created by Admin on 25.08.16.
 */
public class Restaurant
{
    public static void main(String[] args)
    {
        Tablet tbl = new Tablet(5);
        Cook cook = new Cook("Amigo");
        Waitor waitor = new Waitor();
        tbl.addObserver(cook);
        cook.addObserver(waitor);
        tbl.createOrder();
    }
}
