package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] n= new int[4];
        for (int i=0; i<4; i++)
        {
            n[i] = Integer.parseInt(reader.readLine());
        }
        int max=n[0];
        for (int i =1; i<4; i++)
        {
            if (n[i]>max) max=n[i];
        }

        System.out.print(max);


    }
}
