package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны». Если имена разные,
но их длины равны – вывести сообщение – «Длины имен равны».
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        if (s1.length() != s2.length()) return;
        else
        {
            for(int i =0; i<s1.length(); i++)
            {
                if(s1.charAt(i)!=s2.charAt(i))
                {
                    System.out.print("Длины имен равны");
                    return;
                }
            }
            System.out.print("Имена идентичны");
        }

    }
}
