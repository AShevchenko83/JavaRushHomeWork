package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args)
    {
        Human s1 = new Human("Ваня", true, 4, new ArrayList<Human>());
        Human s2 = new Human("Ваня", true, 3, new ArrayList<Human>());
        Human s3= new Human("Ваня", true, 2, new ArrayList<Human>());


        Human pap = new Human("Ваня", true, 25, new ArrayList<Human>(Arrays.asList(s1,s2,s3)));
        Human mam = new Human("Глаша", false, 25, new ArrayList<Human>(Arrays.asList(s1,s2,s3)));
        Human ded1= new Human("Ваня", true, 55, new ArrayList<Human>(Arrays.asList(pap)));
        Human baba1 = new Human("Глаша", false, 55, new ArrayList<Human>(Arrays.asList(pap)));
        Human ded2 = new Human("Ваня", true, 55, new ArrayList<Human>(Arrays.asList(mam)));
        Human baba2 = new Human("Глаша", false, 55, new ArrayList<Human>(Arrays.asList(mam)));

        System.out.println(ded1);
        System.out.println(baba1);
        System.out.println(ded2);
        System.out.println(baba2);
        System.out.println(pap);
        System.out.println(mam);
        System.out.println(s1);
        System.out.println(s1);
        System.out.println(s1);


    }

    public static class Human
    {
        //напишите тут ваш код
        public String name;
        public boolean sex;
        public  int age;
        public ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name=name;
            this.sex= sex;
            this.age = age;
            this.children= children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
