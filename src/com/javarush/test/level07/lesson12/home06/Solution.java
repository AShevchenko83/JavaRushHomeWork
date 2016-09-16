package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args)
    {
        Human gf1 = new Human("sdgs", true, 55, null, null);
        Human gf2 = new Human("dfghdghd", true, 57, null, null);
        Human gm1 = new Human("kng", false, 50, null, null);
        Human gm2 = new Human("kgnjiren", false, 52, null, null);

        Human f = new Human("mkort", true, 30, gf1, gm1);
        Human m = new Human("qwren", false, 27, gf2, gm2);

        Human s1 = new Human("mdfhkj", true, 5, f, m);
        Human s2 = new Human("sgnskj", true, 4, f, m);
        Human s3= new Human("tgr", true, 2, f, m);
        ArrayList<Human> hum = new ArrayList<>();

        Collections.addAll(hum, gf1, gf2, gm1, gm2, f, m, s1, s2, s3);

        for (Human x  : hum)
        {
            System.out.println(x);
        }

    }

    public static class Human
    {
        public String name;
        public boolean sex;
        public  int age;
        public Human father;
        public Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
