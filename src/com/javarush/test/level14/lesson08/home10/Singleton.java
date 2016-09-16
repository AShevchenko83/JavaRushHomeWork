package com.javarush.test.level14.lesson08.home10;

/**
 * Created by Admin on 20.05.16.
 */
public class Singleton
{
   private static Singleton s;
   public static Singleton getInstance()
   {
       if (s==null) s= new Singleton();
       return s;
   }
    /*private  static class Single
    {
        private  static final Singleton s= new Singleton();
    }*/
    private Singleton() {}

}
