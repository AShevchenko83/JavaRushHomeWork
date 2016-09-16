package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
               int[] n= new int[3];
        for (int i=0; i<n.length; i++)
        {
            n[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(n);
        for(int i= n.length-1; i>=0; i--)
        {
            System.out.println(n[i]);
        }


    }
}
