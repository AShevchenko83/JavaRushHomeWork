package com.javarush.test.level13.lesson11.bonus02;

public class Person implements RepkaItem
{
    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh)
    {
        this.name = name;
        this.namePadezh = namePadezh;
    }

    public String getNamePadezh()
    {
        return this.namePadezh;
    }

    void pull(Person p)
    {
        System.out.println(this.name + " за "+p.getNamePadezh());
    }
}
