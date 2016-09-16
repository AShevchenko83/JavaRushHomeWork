package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Admin on 19.05.16.
 */
public class MoldovanHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 45;
    }
    public String getDescription()
    {
        return super.getDescription()+ " Моя страна - "+Country.MOLDOVA
                +". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
