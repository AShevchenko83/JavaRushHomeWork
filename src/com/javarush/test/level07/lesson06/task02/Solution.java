package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> num= new ArrayList<Integer>();
        int max=0;
        for ( int i =0; i <5; i++)
        {
            list.add(reader.readLine());
            num.add(list.get(i).length());
            if (i==0) max=num.get(i);
            else if(max<num.get(i)) max=num.get(i);
        }

        for ( int i = 0; i<5; i++)
        {
            if (num.get(i)==max) System.out.println(list.get(i));
        }






    }
}
