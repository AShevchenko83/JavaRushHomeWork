package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Admin on 08.08.16.
 */
public class LoggingStateThread extends Thread{
    Thread thread;
    public LoggingStateThread(Thread target){
        thread=target;
        setDaemon(true);
    }

    @Override
    public void run()
    {
        Thread.State state = thread.getState();
        System.out.println(state);
        while(state != State.TERMINATED)
        {
            if (state != thread.getState())
            {
                state = thread.getState();
                System.out.println(state);
            }
        }
        interrupt();
    }
}
