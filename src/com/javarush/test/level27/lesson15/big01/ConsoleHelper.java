package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 26.08.16.
 */
public class ConsoleHelper
{
    private static BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString()throws Exception{
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder()throws Exception{
        List<Dish> result = new ArrayList<>();
        writeMessage("Choose the dish, please");
        writeMessage(Dish.allDishesToString());
        String str = readString();
        while(!str.toLowerCase().equals("exit")){
            try
            {
                result.add(Dish.valueOf(str));
            }
            catch(IllegalArgumentException e){
                writeMessage(str + " is not detected");
            }
            str = readString();
        }
        return result;
    }
}
