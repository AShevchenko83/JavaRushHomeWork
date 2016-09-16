package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Admin on 19.05.16.
 */
public class UkrainianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 55;
    }
    public String getDescription()
    {
        return super.getDescription()+ " Моя страна - "+Country.UKRAINE
                +". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
