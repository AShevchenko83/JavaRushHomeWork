package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //ArrayList<String> list = new ArrayList<>();
        while (true)
        {
            String str = reader.readLine();
            if( str.equals("exit")) break;
            /*int num=0;
            int point = 0;
            boolean number= false;
            for (int i = 0; i < str.length();i++)
            {
                if(Character.isDigit(str.charAt(i))) num++;
                if (str.charAt(i)== '.') point ++;
            }
            if(((num+point)==str.length())&&point<2) number = true;
            if(number)
            {
                if (str.contains(".")) print(Double.parseDouble(str));
                else if(Integer.parseInt(str)>0&&Integer.parseInt(str)<128)
                    print((short)Short.parseShort(str));
                else if (Integer.parseInt(str)>=128) print(Integer.parseInt(str));
                else print(str);
            }*/

            try
            {
                if (str.contains(".")) print(Double.parseDouble(str));
                else if(Integer.parseInt(str)>0&&Integer.parseInt(str)<128)
                    print((short)Short.parseShort(str));
                else if (Integer.parseInt(str)>=128) print(Integer.parseInt(str));
                else print(str);
            }
            catch (NumberFormatException e)
            {
                print(str);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
