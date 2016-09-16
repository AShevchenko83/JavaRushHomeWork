package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index)
на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    public static synchronized void create(String [] args) throws ParseException
    {
        int num = (args.length ) / 3;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (int i = 0; i < num; i++)
        {

                if (args[2 + i * 3].equals("м"))
                {
                    allPeople.add(Person.createMale(args[1 + i * 3], format.parse(args[3+i*3])));
                    System.out.print((allPeople.size() - 1)+" ");
                }
                if (args[2 + i * 3].equals("ж"))
                {
                    allPeople.add(Person.createFemale(args[1 + i * 3], format.parse(args[3+i*3])));
                    System.out.print((allPeople.size() - 1)+ " ");
                }

        }
    }

    public static synchronized void update(String[] args) throws ParseException
    {
        int num= (args.length)/4;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (int i=0; i<num; i++)
        {

            int id = Integer.parseInt(args[1 + i * 4]);
            allPeople.get(id).setBirthDay(format.parse(args[4 + i * 4]));
            allPeople.get(id).setName(args[2 + i * 4]);
            if (args[3 + i * 4].equals("м"))
                allPeople.get(id).setSex(Sex.MALE);
            if (args[3 + i * 4].equals("ж"))
                allPeople.get(id).setSex(Sex.FEMALE);
        }

    }



    public static synchronized void delete(String[] args)
    {
        int num = args.length-1;
        for (int i=0; i<num; i++)
        {
            int id= Integer.parseInt(args[1+i]);
            allPeople.get(id).setName(null);
            allPeople.get(id).setBirthDay(null);
            allPeople.get(id).setSex(null);
        }
    }

    public static synchronized void info(String[]  args)
    {
        int num = args.length-1;
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH );
        for (int i=0; i< num; i++)
        {
            int id = Integer.parseInt(args[1+i]);
            String name= allPeople.get(id).getName();
            String sex = null;
            if(allPeople.get(id).getSex()==Sex.MALE)
                sex= "м";
            if (allPeople.get(id).getSex()==Sex.FEMALE)
                sex= "ж";
            String date = dateFormat.format(allPeople.get(id).getBirthDay());
            System.out.print(name+" "+sex+ " "+date);
            System.out.println(" ");
        }
    }

    public static void main(String[] args) throws ParseException{
        //start here - начни тут
        if(args[0].equals("-c")) create(args);
        else if (args[0].equals("-u")) update(args);
        else if (args[0].equals("-d")) delete(args);
        else if (args[0].equals("-i")) info(args);

        /*SimpleDateFormat dateFormat =
                new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH );
        for (int i = 0; i < allPeople.size(); i++)
        {
            System.out.println(allPeople.get(i).getName()+" "+allPeople.get(i).getSex()+
             " "+ dateFormat.format(allPeople.get(i).getBirthDay()));
        }*/

    }
}
