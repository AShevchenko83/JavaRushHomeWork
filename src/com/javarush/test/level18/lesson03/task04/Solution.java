package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        reader.close();
        int[] array = new int[256];
        while (inputStream.available()>0)
        {
            int next = inputStream.read();
            array[next]++;
        }
        inputStream.close();


        for (int i = 0; i < array.length; i++)
        {
            if (array[i]==1) System.out.print(i+ " ");
        }
    }
}
