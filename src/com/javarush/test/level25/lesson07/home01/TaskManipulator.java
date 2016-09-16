package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator  implements Runnable, CustomThreadManipulator{
    Thread thread;
    String name;


    @Override
    public void run() {
        try
        {
            while (!thread.isInterrupted())
            {
                int time=100;
                System.out.println(name);
                thread.sleep(time);
                time+=100;
            }

        }
        catch (InterruptedException e)
        {
        }
    }

    @Override
    public void start(String threadName)
    {
        name=threadName;
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void stop()
    {
        thread.interrupt();
    }
}
