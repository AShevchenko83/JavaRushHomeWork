package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и
разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo&obj=20&obj=Test&obj=20.15
http://javarush.ru/alpha/index.html?lvl=15&view&name=Aobjmigo&obj=3.14&name=&obj=djsdcd&
oobj=3.0&obj=1&obj=2.3&obj=aaa

http://javarush.ru/alpha/index.html?lvl=15&view&name=Aobjmigo&obj&name=&obj=
djsdcd&oobj=3.0&objI=1&objD=2.3&obj

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        try
        {
            BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
            String url= reader.readLine();
            String urlObj=url;
            ArrayList<String> param = new ArrayList<>();
            ArrayList<String> obj = new ArrayList<>();
            while(true)
            {
                if(url.indexOf('?')>-1&& url.indexOf('?')!=url.length()-1)
                    url=url.substring(url.indexOf('?')+1);
                else if(url.indexOf('&')>-1&& url.indexOf('&')!=url.length()-1)
                    url=url.substring(url.indexOf('&')+1);
                else break;

                if((url.indexOf('=')==-1)&& (url.indexOf('&')==-1))
                    param.add(url);
                else if ((url.indexOf('=')>-1&&url.indexOf('&')>-1&&
                        url.indexOf('=')<url.indexOf('&'))||
                        (url.indexOf('=')>-1&&url.indexOf('&')==-1))
                    param.add(url.substring(0,url.indexOf('=')));
                else
                    param.add(url.substring(0,url.indexOf('&')));

            }

            for (int i = 0; i < param.size(); i++)
            {
                if(i<param.size()-1) System.out.print(param.get(i)+" ");
                else System.out.println(param.get(i));
            }

            while(true)
            {
                try
                {
                    if(!urlObj.contains("&obj=")) break;
                    int in= urlObj.length()-5;
                    for (int i = 0; i < in; i++)
                    {
                        if (urlObj.substring(i).startsWith("&obj="))
                        {
                            urlObj=urlObj.substring(i+5);
                            break;
                        }
                    }

                    if(urlObj.indexOf('&')==-1) obj.add(urlObj);
                    else obj.add(urlObj.substring(0,urlObj.indexOf('&')));
                }
                catch (StringIndexOutOfBoundsException e)
                {
                    System.out.println(urlObj);
                    System.out.println(obj);
                }

            }

            int digit=0;
            int point=0;
            for (int i = 0; i < obj.size(); i++)
            {
                for (int j = 0; j < obj.get(i).length(); j++)
                {
                    if(Character.isDigit(obj.get(i).charAt(j))) digit++;
                    if (obj.get(i).charAt(j)=='.') point++;
                }

                if (digit+point==obj.get(i).length()&& point<2)
                    alert(Double.parseDouble(obj.get(i)));
                else alert(obj.get(i));
                digit=0;
                point=0;
            }



        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
