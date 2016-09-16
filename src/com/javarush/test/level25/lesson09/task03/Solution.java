package com.javarush.test.level25.lesson09.task03;

import java.util.ArrayList;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        ArrayList<Throwable> list= new ArrayList<>();
        list.add(e);
        while (true){
            Throwable throwable = list.get(list.size()-1).getCause();
            if (throwable==null) break;
            else list.add(throwable);
        }

        for (int i = list.size()-1; i >=0 ; i--)
        {
            System.out.println(list.get(i).getClass().getName()+": " +list.get(i).getMessage());
        }
    }

    /*public static void main(String[] args)
    {
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                throw new RuntimeException("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
            }
        });

        thread.setUncaughtExceptionHandler(new Solution());
        thread.start();

    }*/
}
