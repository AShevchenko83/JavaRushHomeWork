package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

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
        for (Map.Entry<String, Double> pair: map.entrySet()             ) {
            System.out.println(pair.getKey()+ " "+pair.getValue());
        }
        reader.close();
    }
}
