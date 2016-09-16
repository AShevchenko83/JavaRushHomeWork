package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stallone1", new Date("MAY 1 1980"));
        map.put("Stallone2", new Date("SEPTEMBER 1 1980"));
        map.put("Stallone3", new Date("MAY 1 1980"));
        map.put("Stallone4", new Date("JUNE 1 1980"));
        map.put("Stallone5", new Date("SEPTEMBER 1 1980"));
        map.put("Stallone6", new Date("MAY 1 1980"));
        map.put("Stallone7", new Date("JUNE 1 1980"));
        map.put("Stallone8", new Date("SEPTEMBER 1 1980"));
        map.put("Stallone9", new Date("MAY 1 1980"));

        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String,Date>> iter = map.entrySet().iterator();
        while(iter.hasNext())
        {
            Map.Entry<String, Date> pair = iter.next();
            Date d = pair.getValue();
            if(d.getMonth()>4&&d.getMonth()<8) iter.remove();
        }

    }

    /*public static void main(String[] args)
    {
        HashMap<String, Date> map = createMap();

        removeAllSummerPeople(map);

        for (Map.Entry<String, Date> x :
                map.entrySet())
        {
            System.out.println(x.getKey()+ "; "+x.getValue());
        }
    }*/
}
