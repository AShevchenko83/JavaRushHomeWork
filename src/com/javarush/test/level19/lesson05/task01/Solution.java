package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1= reader.readLine();
        String file2= reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        for (int i = 1 ; inputStream.available()>0; i++)
        {
            int buffer = inputStream.read();
            if((i%2)==0) outputStream.write(buffer);
        }
        inputStream.close();
        outputStream.close();
    }
}
