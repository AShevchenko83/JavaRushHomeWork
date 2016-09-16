package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
            String file1= reader.readLine();
            String file2= reader.readLine();
            String file3= reader.readLine();
            reader.close();
            FileInputStream inputStream = new FileInputStream(file1);
            int count2 = inputStream.available()/2;
            int count1= inputStream.available() - count2;
            byte[] buffer1 = new byte[count1];
            byte[] buffer2 = new byte[count2];
            inputStream.read(buffer1);
            inputStream.read(buffer2);
            inputStream.close();
            FileOutputStream outputStream1 =new FileOutputStream(file2);
            FileOutputStream outputStream2 =new FileOutputStream(file3);
            outputStream1.write(buffer1);
            outputStream2.write(buffer2);
            outputStream1.close();
            outputStream2.close();
        }
        catch (IOException e)
        {

        }

    }
}
