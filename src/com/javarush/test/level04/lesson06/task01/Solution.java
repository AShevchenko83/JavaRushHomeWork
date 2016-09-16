package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        int d1= Integer.parseInt(reader.readLine());
        int d2= Integer.parseInt(reader.readLine());
        if(d1>d2) System.out.println(d2);
        else System.out.println(d1);

    }
}