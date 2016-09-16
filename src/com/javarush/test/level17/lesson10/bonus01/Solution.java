package com.javarush.test.level17.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

            switch (args[0])
            {
                case "-c":
                {
                    if (args[2].equals("м"))
                    {
                        int year = Integer.parseInt(args[3].substring(6)) - 1900;
                        int month = Integer.parseInt(args[3].substring(3, 5)) - 1;
                        int day = Integer.parseInt(args[3].substring(0, 2));
                        allPeople.add(Person.createMale(args[1], new Date(year, month, day)));
                        System.out.println(allPeople.size() - 1);
                    }
                    if (args[2].equals("ж"))
                    {
                        int year = Integer.parseInt(args[3].substring(6)) - 1900;
                        int month = Integer.parseInt(args[3].substring(3, 5)) - 1;
                        int day = Integer.parseInt(args[3].substring(0, 2));
                        allPeople.add(Person.createFemale(args[1], new Date(year, month, day)));
                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                }

                case "-u":
                {
                    int id= Integer.parseInt(args[1]);
                    int year = Integer.parseInt(args[4].substring(6)) - 1900;
                    int month = Integer.parseInt(args[4].substring(3, 5)) - 1;
                    int day = Integer.parseInt(args[4].substring(0, 2));
                    allPeople.get(id).setBirthDay(new Date(year, month, day));
                    allPeople.get(id).setName(args[2]);
                    if(args[3].equals("м"))
                        allPeople.get(id).setSex(Sex.MALE);
                    if (args[3].equals("ж"))
                        allPeople.get(id).setSex(Sex.FEMALE);
                    break;
                }

                case "-d":
                {
                    int id= Integer.parseInt(args[1]);
                    allPeople.get(id).setName(null);
                    allPeople.get(id).setBirthDay(null);
                    allPeople.get(id).setSex(null);
                    break;
                }

                case  "-i":
                {
                    int id = Integer.parseInt(args[1]);
                    System.out.print(allPeople.get(id).getName()+" ");
                    if(allPeople.get(id).getSex()==Sex.MALE)
                        System.out.print("м"+" ");
                    if (allPeople.get(id).getSex()==Sex.FEMALE)
                        System.out.print("ж"+" ");
                    SimpleDateFormat dateFormat =
                            new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH );
                    System.out.print
                            (dateFormat.format(allPeople.get(id).getBirthDay()));
                    break;
                }
            }





    }
}
