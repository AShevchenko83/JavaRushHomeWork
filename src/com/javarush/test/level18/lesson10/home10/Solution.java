package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например,
Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без
приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть,
потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file = reader.readLine();
            int fileCount = 0;
            while (!(file.equals("end")))
            {
                fileCount++;
                String temp = reader.readLine();
                if (temp.equals("end")) break;
                else file = temp;
            }
            reader.close();

            int lastPointIndex=0;
            for (int i = file.length()-1; i >=0 ; i--)
            {
                if(file.charAt(i)==46)
                {
                    lastPointIndex=i;
                    break;
                }
            }

            String fileName= file.substring(0, lastPointIndex);
            FileOutputStream outputStream = new FileOutputStream(fileName, true);
            FileInputStream inputStream = null;

            for (int i = 0; i < fileCount; i++)
            {
                String tempFile = fileName+".part"+(i+1);
                inputStream = new FileInputStream(tempFile);
                while (inputStream.available()>0)
                {
                    int buff = inputStream.read();
                    outputStream.write(buff);
                }
                inputStream.close();
            }
            outputStream.close();
        }
        catch(IOException e){}




    }
}
