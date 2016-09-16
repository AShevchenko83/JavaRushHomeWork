package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a= Integer.parseInt(reader.readLine());
        int[] n =new  int[a];
        for (int i = 0; i<a; i++)
        {
            n[i]=Integer.parseInt(reader.readLine());
        }

        System.out.println(maximum(n));
    }


    public static int maximum(int [] arr)
    {
        int max=arr[0];
        for (int i=1; i<arr.length; i++)
        {
            if (max<arr[i]) max=arr[i];
        }
        return max;
    }
}
