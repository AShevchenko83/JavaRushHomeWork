package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        if(string==null) throw new TooShortStringException();
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i)=='\t'&& index1==-1) index1=i;
            else if(string.charAt(i)=='\t'&& index1!=-1&&index2==-1) index2=i;
        }

        if(index2==-1) throw new TooShortStringException();
        return string.substring(index1+1, index2);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                     //Exception
    }
}
