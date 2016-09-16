package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) {

        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            reader.close();
            String[] str;
            BufferedReader reader1= new BufferedReader(new FileReader(file1));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file2, true));

            while(reader1.ready())
            {
                str= reader1.readLine().split(" ");
                for (int i = 0; i < str.length; i++)
                {
                    writer.write(((Long)Math.round(Double.parseDouble(str[i]))).toString());
                    writer.write(" ");
                }
                writer.write("\n");
            }
            reader1.close();
            writer.close();
        }
        catch (IOException e)
        {

        }

    }
}
