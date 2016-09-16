package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try //2
        {
            InputStream in =new FileInputStream("ult");


        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try //3
        {
            int[] a= new int[]{1,2,3,4,5,6,7,8,9,10};
            int b = a[10];


        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try //4
        {
            String s=null;
            char[] c = s.toCharArray();


        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try //5
        {
            Object s = "error";
            double d = (double)s;


        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try //2
        {
            InputStream in =new FileInputStream("ult");


        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try //3
        {
            int[] a= new int[]{1,2,3,4,5,6,7,8,9,10};
            int b = a[10];


        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try //4
        {
            String s=null;
            char[] c = s.toCharArray();


        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try //5
        {
            Object s = "error";
            double d = (double)s;


        } catch (Exception e)
        {
            exceptions.add(e);
        }

    }
}
