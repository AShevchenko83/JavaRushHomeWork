package com.javarush.test.level25.lesson11.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Admin on 12.08.16.
 */
public class Fibo
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] split= reader.readLine().split(" ");
            int a= Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            reader.close();
            System.out.println(del(a,b));

        }
        catch (IOException e)
        {

        }


    }

    public static int del (int a, int b ){
        if(a==0) return b;
        if(b==0) return a;
        if(a>b) return del(b, a%b);
        else return del(a, b%a);
    }


}
