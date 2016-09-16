package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз,
и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try
        {
            BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
            String filename=null;
            while (!((filename=reader.readLine()).equals("exit")))
            {
                new ReadThread(filename).start();
            }
            reader.close();
        }
        catch (IOException e) {}

    }

    public static class ReadThread extends Thread {
        String file;
        public ReadThread(String fileName) {
            //implement constructor body
            file=fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run()
        {
            try
            {
                FileInputStream inputStream= new FileInputStream(file);
                int[] items = new int[256];
                if (!(inputStream.available()>0))
                {    synchronized (resultMap)
                    {
                        resultMap.put(file, 0);
                    }
                }
                while (inputStream.available()>0)
                {
                    int next = inputStream.read();
                    items[next]++;
                }

                int index =0;
                for (int i = 1; i < items.length; i++)
                {
                    if (items[i]>=items[index]) index=i;
                }

                synchronized (resultMap)
                {
                    resultMap.put(file, index);
                }

                inputStream.close();

            }
            catch (IOException e) {}
        }
    }
}
