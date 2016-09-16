package com.javarush.test.level22.lesson13.task03;

import java.util.ArrayList;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {
    /*public static void main(String[] args)
    {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("(050)123-456-7"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));
    }*/


    public static boolean checkTelNumber(String telNumber) {
        if(telNumber==null||telNumber.length()==0) return false;
        if(!Character.isDigit(telNumber.charAt(telNumber.length()-1))) return false;
        ArrayList<Integer> scobaL = new ArrayList<>();
        ArrayList<Integer> scobaR = new ArrayList<>();
        ArrayList<Integer> defis = new ArrayList<>();
        for (int i = 0; i < telNumber.length(); i++) {
            char ch = telNumber.charAt(i);
            if(ch=='(') scobaL.add(i);
            if(ch==')') scobaR.add(i);
            if(ch=='-') defis.add(i);
        }
        int lSize = scobaL.size();
        int rSize = scobaR.size();
        int defSize = defis.size();
        if(lSize>1||rSize>1||defSize>2) return false;
        if((lSize==0&&rSize>0)||(lSize>0&&rSize==0)) return false;
        if((lSize>0&&rSize>0) &&
                (scobaL.get(0)>scobaR.get(0)||(scobaR.get(0)-scobaL.get(0))!=4)) return false;
        if((rSize>0&&defSize>0) &&(scobaR.get(0)>defis.get(0))) return false;
        if(defSize==2 && (defis.get(1)-defis.get(0))<2) return false;

        String newTel=telNumber.replaceAll("[()-]", "");
        if( newTel.matches("\\+\\d{12}") || newTel.matches("\\d{10}")) return true;

        return false;
    }
}

