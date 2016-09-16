package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int n = 5;
        int[] num1 = new int[n];
        int[] num2 = new int[10];
        int[] num3 = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for ( int i =0; i<n; i++)
        {
            num1[i] = Integer.parseInt(reader.readLine());
            //if (i<10) num2[i]=num1[i];
            //else num3[i-10]=num1[i];
        }

        for ( int i = 0; i<n ; i++)
            System.out.println(num1[i]);


    }
}
