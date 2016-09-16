package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new InputStreamReader
                (new FileInputStream(fileName)));
        String line = "";
        while (fileReader.ready()){
            line+=fileReader.readLine()+ " ";
        }
        fileReader.close();
        String[] split = line.split(" ");
        for (int i = 0; i < split.length-1; i++) {
            for (int j = i+1 ; j <split.length ; j++) {
                if(split[i]==null||split[j]==null) continue;
                StringBuilder first = new StringBuilder(split[i]);
                StringBuilder second = new StringBuilder(split[j]);
                if(first.toString().equals(second.reverse().toString())){
                    Pair pair = new Pair();
                    pair.first= first.toString();
                    pair.second= second.reverse().toString();
                    result.add(pair);
                    split[i]=null;
                    split[j]=null;
                }
            }
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
