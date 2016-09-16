package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fileWriter = new FileWriter(reader.readLine());
        ArrayList<String> str = new ArrayList<>();
        while (true)
        {
            str.add(reader.readLine());
            if ((str.get(str.size()-1)).equals("exit")) break;
        }
        for (String s:   str          )
        {
            String Separator = System.lineSeparator();
            fileWriter.write(s);
            fileWriter.write(Separator);
            fileWriter.flush();
        }
        fileWriter.close();
        reader.close();



    }
}
