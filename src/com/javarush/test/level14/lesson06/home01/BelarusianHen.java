package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Admin on 19.05.16.
 */
public class BelarusianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 40;
    }
    public String getDescription()
    {
        return super.getDescription()+ " Моя страна - "+Country.BELARUS
                +". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
