package com.javarush.test.level08.lesson11.home01;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();

        Iterator<Cat> iter = cats.iterator();
        iter.next();
        iter.remove();

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        //напишите тут ваш код. пункт 2
        HashSet<Cat> cats = new HashSet<>();
        cats.add(new Cat("Васька"));
        cats.add(new Cat("Мурчик"));
        cats.add(new Cat("Рыжий"));
        return cats;
    }

    public static void printCats(Set<Cat> cats)
    {
        // пункт 4
        for (Cat name: cats             )
        {
            System.out.println(name);
        }
    }

    public  static class Cat
    {
        public String name= null;
        public Cat(String name)
        {
            this.name=name;
        }
    }
}
