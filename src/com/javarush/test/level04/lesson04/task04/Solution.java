package com.javarush.test.level04.lesson04.task04;

/* Время года
Реализовать метод checkSeason. По номеру месяца, метод должен определить время года (зима, весна, лето, осень) и вывести на экран.
Пример для номера месяца 2:
зима
Пример для номера месяца 5:
весна
*/

public class Solution
{
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int m){
        if(m>2&&m<6) System.out.println("весна");
        else if (m>5&&m<9) System.out.println("лето");
        else if (m>8&&m<12) System.out.println("осень");
        else System.out.println("зима");
    }
}