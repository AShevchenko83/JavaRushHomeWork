package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {
        //System.out.println(new Human());
        //System.out.println(new Human("Лёша", "Печеров", 30,212, 110, "Киев"));
    }

    public static class Human
    {
        private String firstName;
        private  String secondName;
        private int age;
        private int height;
        private int weight;
        private String adress;

        public Human()//1
        {
            firstName = "Вася";
            secondName = "Пупкин";
            age = 30;
            height = 180;
            weight = 80;
            adress = "Урюпинск";
        }

        public Human(String name)//2
        {
            firstName = name;
            secondName = "Пупкин";
            age = 30;
            height = 180;
            weight = 80;
            adress = "Урюпинск";
        }

        public Human(String name, String name2)//3
        {
            firstName = name;
            secondName = name2;
            age = 30;
            height = 180;
            weight = 80;
            adress = "Урюпинск";
        }

        public Human(String name, String name2, int age)//4
        {
            firstName = name;
            secondName = name2;
            this.age = age;
            height = 180;
            weight = 80;
            adress = "Урюпинск";
        }

        public Human(String name, String name2, int age, int height)//5
        {
            firstName = name;
            secondName = name2;
            this.age = age;
            this.height = height;
            weight = 80;
            adress = "Урюпинск";
        }

        public Human(String name, String name2, int age, int height, int weight)//6
        {
            firstName = name;
            secondName = name2;
            this.age = age;
            this.height = height;
            this.weight = weight;
            adress = "Урюпинск";
        }

        public Human(String name, String name2, int age, int height, int weight, String adr)//7
        {
            firstName = name;
            secondName = name2;
            this.age = age;
            this.height = height;
            this.weight = weight;
            adress = adr;
        }

        public Human(String name2, int age)//8
        {
            firstName = "Вася";
            secondName = name2;
            this.age = age;
            this.height = 180;
            this.weight = 80;
            adress = "Урюпинск";
        }
        public Human(String name2, int age, int height)//9
        {
            firstName = "Вася";
            secondName = name2;
            this.age = age;
            this.height = height;
            this.weight = 80;
            adress = "Урюпинск";
        }

        public Human(String name2, int age, int height, String adr)//10
        {
            firstName = "Вася";
            secondName = name2;
            this.age = age;
            this.height = height;
            this.weight = 80;
            adress = adr;
        }

    }

}
