package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.Arrays;

/**
 * Created by Admin on 25.08.16.
 */
public enum Dish
{
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    Dish(int duration)
    {
        this.duration = duration;
    }

    public int getDuration()
    {
        return duration;
    }

    public static String allDishesToString(){

        String line=new String();
        for(int i=0; i< Dish.values().length; i++){
            line+=Dish.values()[i].name();
            if(i<Dish.values().length-1) line+=", ";
        }
        return line;
    }
}
