package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader=
                new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "utf-8"));
        TreeMap<String, Double> map = new TreeMap<>();
        while (reader.ready()){
            String[] split= reader.readLine().split(" ");
            if(!map.keySet().contains(split[0])) map.put(split[0], Double.parseDouble(split[1]));
            else {
                double value= map.get(split[0]);
                map.put(split[0], value+Double.parseDouble(split[1]));
            }
        }
        double max=0;
        for (Map.Entry<String, Double> pair: map.entrySet()             ) {
            if(pair.getValue()>max) max= pair.getValue();
        }
        for (Map.Entry<String, Double> pair: map.entrySet()) {
            if (pair.getValue()==max) System.out.println(pair.getKey());
        }
        reader.close();
    }
}
