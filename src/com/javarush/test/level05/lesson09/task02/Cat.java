package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String  name = null;
    private int weight  = 0;
    private int age = 0;
    public String color = null;
    public String home = null;

    public Cat(String name)
    {
        this.name = name;
    }

    public Cat(String name, int weight, int age)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public Cat(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Cat(int weight, String color)
    {

        this.weight = weight;
        this.color = color;
    }

    public Cat(int weight, String color, String home)
    {

        this.weight = weight;
        this.color = color;
        this.home = home;
    }

    public static void main(String[] args)
    {
        Cat cat = new Cat("Эрвин", 4,6);

    }

}