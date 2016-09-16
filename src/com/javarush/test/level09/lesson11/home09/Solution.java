package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        HashMap<String, Cat> mapCat= new HashMap<>();
        mapCat.put("Васька1", new Cat("Васька1"));
        mapCat.put("Васька2", new Cat("Васька2"));
        mapCat.put("Васька3", new Cat("Васька3"));
        mapCat.put("Васька4", new Cat("Васька4"));
        mapCat.put("Васька5", new Cat("Васька5"));
        mapCat.put("Васька6", new Cat("Васька6"));
        mapCat.put("Васька7", new Cat("Васька7"));
        mapCat.put("Васька8", new Cat("Васька8"));
        mapCat.put("Васька9", new Cat("Васька9"));
        mapCat.put("Васька10", new Cat("Васька10"));

        return mapCat;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        HashSet<Cat> setCat = new HashSet<>(map.values());
        return setCat;

    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
