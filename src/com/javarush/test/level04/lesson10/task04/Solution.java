package com.javarush.test.level04.lesson10.task04;

import java.io.*;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int i=1;
        while( i<11)
        {
            int j=1;
            while (j<11)
            {
                if(j==10) System.out.println("S");
                else
                    System.out.print("S");
                    j++;

            }
            i++;
        }

    }
}
