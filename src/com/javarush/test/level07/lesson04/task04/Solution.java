package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int [] num= new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for ( int i =0; i< num.length; i++)
        {
            num[i]= Integer.parseInt(reader.readLine());
        }
        swap(num);

        for ( int i =0; i< num.length; i++)
        {
            System.out. println(num[i]);
        }



    }

    public static void swap (int[] arr)
    {
        int temp;
        for (int i = 0;i< arr.length; i++)
        {
            if(i==(arr.length-1-i)||i>(arr.length-1-i)) return;
            else
            {
                temp=arr[i];
                arr[i]=arr[arr.length-1-i];
                arr[arr.length-1-i] = temp;
            }
        }
    }
}
