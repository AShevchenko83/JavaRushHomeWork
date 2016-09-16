package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так,
чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
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
            reader = new BufferedReader(new FileReader(file1));
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str=reader.readLine())!=null)
            {
                sb.append(str);
                sb.append("\n");
            }
            reader.close();
            FileInputStream inputStream= new FileInputStream(file2);
            FileOutputStream outputStream= new FileOutputStream(file1);
            while (inputStream.available()>0)
            {
                int next= inputStream.read();
                outputStream.write(next);

            }
            inputStream.close();
            outputStream.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file1,true));
            str = sb.toString();
            writer.write(str);
            writer.close();
        }
        catch (IOException e) {}

    }
}
