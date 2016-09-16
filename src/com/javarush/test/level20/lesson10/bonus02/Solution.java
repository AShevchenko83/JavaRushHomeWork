package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        byte [][] b= new byte [(a.length)+2][(a.length)+2];
        int size = a.length+2;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i==0||j==0||i==size-1||j==size-1) b[i][j] =0;
                else b[i][j] = a[i-1][j-1];
            }
        }
        /*for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(b[i][j]+ " ");
            }
            System.out.println();
        }*/
        int one=0;
        int two=0;
        int four=0;
        for (int i = 1; i < size-1; i++) {
            for (int j = 1; j < size-1; j++) {
                int sum = b[i-1][j-1]+ b[i-1][j]+b[i-1][j+1]+
                        b[i][j-1]+b[i][j]+b[i][j+1]+
                        b[i+1][j-1]+b[i+1][j]+b[i+1][j+1];
                a[i-1][j-1] = (byte)sum;
                if(b[i][j]==1&&sum==1)one++;
                if(b[i][j]==1&&sum==2) two++;
                if(b[i][j]==1&&sum==4) four++;
            }

        }
        /*for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j]+ " ");
            }
            System.out.println();
        }*/


        return one+two/2+four/4;
    }
}
