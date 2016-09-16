package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("A","AB");
        map.put("B","BC");
        map.put("C","CD");
        map.put("D","AB");
        map.put("E","BC");
        map.put("F","CD");
        map.put("J","AB");
        map.put("I","CD");
        map.put("K","AD");
        map.put("L","BD");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int num=0;
        for (String x :
                map.values())
        {
            if (name.equals(x)) num++;
        }

            return num;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int num=0;
        for (String x :
                map.keySet())
        {
            if (lastName.equals(x)) num++;
        }

        return num;

    }


}
