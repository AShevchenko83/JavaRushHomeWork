package com.javarush.test.level28.lesson06.home01;

/**
 * Created by Admin on 02.09.16.
 */
public class MyThread extends Thread
{
    private static int countPrority=-1;
    public MyThread()
    {
        countPrority++;
        this.setPriority(this.getThreadGroup().getMaxPriority()>=
                countPrority%10+1?countPrority%10+1:this.getThreadGroup().getMaxPriority());
    }

    public MyThread(Runnable target)
    {
        super(target);
        countPrority++;
        this.setPriority(this.getThreadGroup().getMaxPriority()>=
                countPrority%10+1?countPrority%10+1:this.getThreadGroup().getMaxPriority());
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        countPrority++;
        this.setPriority(this.getThreadGroup().getMaxPriority()>=
                countPrority%10+1?countPrority%10+1:this.getThreadGroup().getMaxPriority());
    }

    public MyThread(String name)
    {
        super(name);
        countPrority++;
        this.setPriority(this.getThreadGroup().getMaxPriority()>=
                countPrority%10+1?countPrority%10+1:this.getThreadGroup().getMaxPriority());
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        countPrority++;
        this.setPriority(this.getThreadGroup().getMaxPriority()>=
                countPrority%10+1?countPrority%10+1:this.getThreadGroup().getMaxPriority());
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        countPrority++;
        this.setPriority(this.getThreadGroup().getMaxPriority()>=
                countPrority%10+1?countPrority%10+1:this.getThreadGroup().getMaxPriority());
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        countPrority++;
        this.setPriority(this.getThreadGroup().getMaxPriority()>=
                countPrority%10+1?countPrority%10+1:this.getThreadGroup().getMaxPriority());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        countPrority++;
        this.setPriority(this.getThreadGroup().getMaxPriority()>=
                countPrority%10+1?countPrority%10+1:this.getThreadGroup().getMaxPriority());
    }
}
