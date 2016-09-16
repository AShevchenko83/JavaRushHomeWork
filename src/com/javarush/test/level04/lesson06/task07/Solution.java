package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
*/

import java.io.*;

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
        if (n[0]==n[1]) System.out.print(3);
        else if (n[0]==n[2]) System.out.print(2);
        else System.out.print(1);



    }
}
