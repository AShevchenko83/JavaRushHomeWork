package com.javarush.test.level27.lesson15.big01.ad;

import java.util.Comparator;

/**
 * Created by Admin on 27.08.16.
 */
public class Advertisement implements Comparable<Advertisement>
{
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration)
    {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = initialAmount/hits;
    }

    public String getName()
    {
        return name;
    }

    public int getDuration()
    {
        return duration;
    }

    public int getHits()
    {
        return hits;
    } // моё добавление

    public long getAmountPerOneDisplaying()
    {
        return amountPerOneDisplaying;
    }

    @Override
    public int compareTo(Advertisement o)
    {
        if(this.amountPerOneDisplaying!=o.amountPerOneDisplaying){
            return (int)(o.amountPerOneDisplaying - this.amountPerOneDisplaying);
        }
        else return (int)((this.amountPerOneDisplaying*1000/this.duration) - (o.amountPerOneDisplaying*1000/o.duration));
    }

    public void revalidate(){
        if (hits <= 0) throw new UnsupportedOperationException();
        hits--;
        if (hits == 1) amountPerOneDisplaying += initialAmount % amountPerOneDisplaying;
    }
}
