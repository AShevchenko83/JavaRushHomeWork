package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {

        try
        {
            int num=0;
            FileInputStream inputStream = new FileInputStream(args[0]);
            while (inputStream.available()>0)
            {
                int next = inputStream.read();
                if((next>=65&&next<=90)||(next>=97&&next<=122)) num++;
            }
            System.out.println(num);
            inputStream.close();
        }
        catch (FileNotFoundException e)
        {

        }
        catch (IOException e) {}
    }
}
