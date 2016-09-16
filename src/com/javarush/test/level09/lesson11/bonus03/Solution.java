package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        ArrayList<String> word = new ArrayList<>();
        ArrayList<String> num= new ArrayList<>();
        for (String x: array             )
        {
            if (isNumber(x)) num.add(x);
            else word.add(x);
        }
        for (int i=0; i<word.size(); i++)
        {
            int min=i;
            for (int j=i+1; j<word.size(); j++)
            {
                if(isGreaterThan(word.get(min), word.get(j))) min=j;
            }
            String temp= word.get(i);
            word.set(i, word.get(min));
            word.set(min, temp);
        }
        for (int i=0; i<num.size(); i++)
        {
            int max=i;
            for (int j=i+1; j<num.size(); j++)
            {
                if(Integer.parseInt(num.get(max))<Integer.parseInt(num.get(j))) max=j;
            }
            String temp= num.get(i);
            num.set(i, num.get(max));
            num.set(max, temp);
        }
        int startWord=0, startNum=0;
        for (int i=0; i<array.length; i++)
        {
            if (isNumber(array[i]))
            {
                array[i]=num.get(startNum++);
            }
            else
            {
                array[i] = word.get(startWord++);
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
