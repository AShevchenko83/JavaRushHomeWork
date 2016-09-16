package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2= reader.readLine();
            reader.close();
            FileInputStream fileInputStream = new FileInputStream(file1);
            byte[] array = new byte[fileInputStream.available()];
            fileInputStream.read(array);
            byte[] array2 = new byte[array.length];
            for (int i = array.length-1, j=0; i>=0; i--, j++ )
            {
                array2[j]=array[i];
            }
            FileOutputStream outputStream = new FileOutputStream(file2);
            outputStream.write(array2);
            fileInputStream.close();
            outputStream.close();
        }
        catch (IOException e)
        {

        }


    }
}
