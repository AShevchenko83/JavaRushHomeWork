package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        final int mediana = array.length%2==0?
                (array[array.length/2]+array[array.length/2-1])/2 :
                array[array.length/2];
        Comparator<Integer> compInt= new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2)
            {
                if(Math.abs(o1-mediana)!= Math.abs(o2-mediana))
                return Math.abs(o1-mediana) - Math.abs(o2-mediana);
                else return o1-  o2;
            }
        };

        Arrays.sort(array, compInt);

        return array;
    }
}
