package com.javarush.test.level08.lesson08.task05;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {

        HashMap<String, String> copy = new HashMap<>(map);
        for (String name: copy.values()             )
        {
            int num=0;
            for (String s: map.values()                 )
            {
                  if (s.equals(name)) num++;
            }
            if (num>1) removeItemFromMapByValue(map,name);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    /*public static void main(String[] args)
    {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        for (Map.Entry<String, String> pair: map.entrySet()
             )
        {
            System.out.println(pair.getKey()+ ": "+pair.getValue());
        }
    } */
}

