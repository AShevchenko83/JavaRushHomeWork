package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    /*static int[][] table = new int[10][12];
    static {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++)
            {
                table[i][j] = (int)Math.pow(i,j);
            }
        }
    }*/

    public static int[] getNumbers(int N) {
        HashSet<Integer> set = new HashSet<>();
        //set.add(0);
        for (int i = 1; i < N; i++) {
           ArrayList<Integer> checkNum = isCheckNum(i);
            if(checkNum==null)continue;
            int num=getArmNum(checkNum);
            int size = 1;
            int n =num;
            while (n/10>0){
                size++;
                n/=10;
            }
            if(isArmNum(num,size)&&num<N) set.add(num);
        }
        int[] result = new int[set.size()];
        int i=0;
        for (Integer n: set             ){
            result[i] = n;
            i++;
        }
        Arrays.sort(result);
        return result;
    }

    public static ArrayList<Integer> isCheckNum (int num){
        ArrayList<Integer> numList = new ArrayList<>();
        int n = num;
        int pos=-1;
        while (n/10>0||n%10>0){
            numList.add(0,n%10);
            n/=10;
            pos++;
            if(numList.get(0)==0) continue;
            else{
                if(numList.get(0)>numList.get(pos)) return numList=null;
                else pos=0;
            }
        }
        return numList;
    }

    public static int getArmNum (ArrayList<Integer> numList){
        int armNum=0;
        int size= numList.size();
        for (Integer digit: numList             ){
            armNum+=Math.pow(digit,size);
        }
        return armNum;
    }

    public static boolean isArmNum(int num, int size){
        int n = num;
        int numArm=0;
        while (n%10>0||n/10>0){
            numArm+=Math.pow(n%10, size);
            if(numArm>num) return false;
            else n/=10;
        }
        if(num==numArm) return true;
        else return false;
    }


    /*public static void main(String[] args)
    {   long a=System.currentTimeMillis();
        int[] result = getNumbers(30000000);
        long b=System.currentTimeMillis();
        System.out.println("time seconds "+(b-a)/1000);
        System.out.println("memory "+(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
        for (int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
        }

    }*/
}
