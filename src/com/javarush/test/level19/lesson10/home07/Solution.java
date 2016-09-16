package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1])));
        ArrayList<String> list = new ArrayList<>();
        while (reader.ready()){
            String[] split = reader.readLine().split(" ");
            if (!reader.ready()) {
                for (int i = 0; i < split.length; i++) {
                    if (split[i].length()>6)
                        if(i<split.length-1) list.add(split[i]+",");
                        else list.add(split[i]);
                }
            }
            else {
                for (int i = 0; i < split.length; i++) {
                    if (split[i].length()>6)
                        if(i<split.length-1) list.add(split[i]+",");
                        else list.add(split[i]+"\n");
                }
            }
        }
        for (int i = 0; i <list.size() ; i++)
        {
            writer.write(list.get(i));
        }
        reader.close();
        writer.close();
    }
    //"windows-1251"
}
