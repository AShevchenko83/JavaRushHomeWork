package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] n =new  int[5];
        for (int i = 0; i<5; i++)
        {
            n[i]=Integer.parseInt(reader.readLine());
        }

        System.out.println("Minimum = " + min(n));
    }


    public static int min(int [] arr)
    {
        int minimum=arr[0];
        for (int i=1; i<5; i++)
        {
            if (minimum>arr[i]) minimum=arr[i];
        }
        return minimum;
    }

}
