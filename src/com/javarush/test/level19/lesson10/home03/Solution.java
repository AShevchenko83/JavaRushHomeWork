package com.javarush.test.level19.lesson10.home03;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader=
                new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        while (reader.ready()){
            String[] split = reader.readLine().split(" ");

            String sb = "";
            for (int i =0; i< split.length-3; i++) {
                sb= sb+split[i];
                if(i<split.length-4) sb=sb+" ";
            }
            int day= Integer.parseInt(split[split.length-3]);
            int month= Integer.parseInt(split[split.length-2])-1;
            int year= Integer.parseInt(split[split.length-1]);
            PEOPLE.add(new Person(sb,
                    new Date(new GregorianCalendar(year,month,day).getTimeInMillis())));

        }
        reader.close();

    }

}
