package com.javarush.test.level25.lesson16.big01;

/**
 * Created by Admin on 11.08.16.
 */
public class Ufo extends BaseObject
{
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1},
    };

    private int moveCount =0;

    public Ufo(double x, double y)
    {
        super(x, y, 3);
    }

    @Override
    public void draw(Canvas canvas)
    {
        canvas.drawMatrix(x - radius + 1, y, matrix, 'M');
    }

    public void fire()
    {
        Space.game.getBombs().add(new Bomb(x,y));
    }

    @Override
    public void move()
    {
        double dx = Math.random() * 2 - 1;
        double dy = Math.random() * 2 - 1;
        if(x+dx-3>=0&&x+dx+3<Space.game.getWidth()) x+=dx;
        if((y+dy)<=Space.game.getHeight()&&y+dy-3>=0) y+=dy;
        moveCount++;
        if(moveCount%10==0) fire();

    }
}

