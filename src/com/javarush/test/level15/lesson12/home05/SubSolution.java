package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Admin on 26.05.16.
 */
public class SubSolution extends Solution
{
    public SubSolution() //1
    {
    }

    public SubSolution(int n) //2
    {
        super(n);
    }

    public SubSolution(String s) //3
    {
        super(s);
    }

    SubSolution(int n, int m) //4
    {
        super(n, m);
    }

    SubSolution(String s, int n) //5
    {
        super(s, n);
    }

    protected SubSolution(char c) //6
    {
        super(c);
    }

    SubSolution(String s, String t, int n) //7
    {

        super(s, t, n);
    }

    protected SubSolution(int n, char c) //8
    {
        super(n, c);
    }

    protected SubSolution(String s, char c) //9
    {
        super(s, c);
    }

    private SubSolution(char c, char d) {}

    private SubSolution(int n, char c, char d) {}

    private SubSolution(String s, char c, char d) {}
}
