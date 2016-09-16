package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена

яа ад абв вга де
*/
public class Solution {
    public static void main(String[] args) {
        String file ="";
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            BufferedReader fileReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(fileName)));
            while (fileReader.ready()){
                file+=fileReader.readLine()+" ";
            }
            fileReader.close();
        }
        catch (IOException e)
        {

        }
        String[] split = file.split(" ");
        StringBuilder result = getLine(split);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        if(words.length==1) return new StringBuilder(words[0]);
        if(words==null||words.length==0) return new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            list.add(words[i]);
        }
        while (!correctList(list)){
            Collections.shuffle(list);
        }

        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if(i<list.size()-1)sb.append(list.get(i)+" ");
            else sb.append(list.get(i));
        }
        return sb;
    }

    public static boolean correctList (ArrayList<String> list){
        for (int i = 0; i < list.size()-1; i++) {
            if(!list.get(i).substring(list.get(i).length()-1,list.get(i).length()).
                    equalsIgnoreCase(list.get(i+1).substring(0,1))) return false;
        }
        return  true;
    }
}
