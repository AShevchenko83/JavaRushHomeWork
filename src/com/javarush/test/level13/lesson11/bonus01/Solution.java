package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        ArrayList<Integer> list = new ArrayList<>();
        String str;
        while(true)
        {
            str= fileReader.readLine();
            if (str==null) break;
            list.add(Integer.parseInt(str));
        }
        for (int i = 0; i < list.size();)
        {
            if ((list.get(i)%2==0)) i++;
            else {list.remove(i);}
        }

        for (int i = 0 ; i< list.size(); i++)
        {
            int min=i;
            for (int j =i+1; j<list.size(); j++)
            {
                if(list.get(j)<list.get(min)) min=j;
            }
            int temp= list.get(i);
            list.set(i, list.get(min));
            list.set(min, temp);

        }
        for (int i = 0; i<list.size(); i++) System.out.println(list.get(i));
        reader.close();
        fileReader.close();
    }
}
