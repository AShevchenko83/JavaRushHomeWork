package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.util.List;

/**
 * Created by Admin on 25.08.16.
 */
public class Order
{
    private Tablet tablet;
    private List<Dish> dishes;

    public Order(Tablet tablet) throws Exception
    {
        this.tablet = tablet;
        dishes= ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString()
    {
        if(dishes.isEmpty()) return "";
        else return "Your order: "+dishes.toString()+" of "+tablet;
    }

    public int getTotalCookingTime(){
        int cookTime=0;
        if(!dishes.isEmpty()){
            for (Dish d: dishes                 )
            {
                cookTime+=d.getDuration();
            }
        }
        return cookTime;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }
}
