package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Admin on 19.07.16.
 */
public class Hippodrome
{
    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;
    public ArrayList<Horse> getHorses(){
        return horses;
    }
    public void run()throws Exception{
        for (int i = 1; i<=100; i++){
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (int i = 0; i<getHorses().size(); i++){
            getHorses().get(i).move();
        }
    }
    public void print(){
        for (int i = 0; i<getHorses().size(); i++){
            getHorses().get(i).print();
            System.out.println();
            System.out.println();
        }
    }

    public Horse getWinner(){
        int indexMax = 0;
        for (int i = 1; i < getHorses().size(); i++)
        {
            if(getHorses().get(i).getDistance()>getHorses().get(indexMax).getDistance()){
                indexMax=i;
            }
        }
        return getHorses().get(indexMax);
    }

    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
    public static void main(String[] args) throws Exception
    {
        game = new Hippodrome();
        Horse first = new Horse("First", 3, 0);
        Horse second = new Horse("Second", 3, 0);
        Horse third = new Horse("Third", 3, 0);
        game.getHorses().add(first);
        game.getHorses().add(second);
        game.getHorses().add(third);
        game.run();
        game.printWinner();
    }
}
