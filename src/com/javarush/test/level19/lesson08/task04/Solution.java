package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

            PrintStream cons = System.out;
            ByteArrayOutputStream array = new ByteArrayOutputStream();
            PrintStream stream = new PrintStream(array);
            System.setOut(stream);
            testString.printSomething();
            System.setOut(cons);
            String line = array.toString()/*.substring(0,array.toString().length()-2 )*/;
            String[] split= line.replaceAll("[^0-9*+-=]","").replaceAll("[^0-9]", " ").split(" ");

            if(line.contains("+")){
                String result = String.valueOf(Integer.parseInt(split[0])+Integer.parseInt(split[1]));
                line = line+result;
            }
            else if(line.contains("-")){
                String result = String.valueOf(Integer.parseInt(split[0])-Integer.parseInt(split[1]));
                line = line+result;
            }
            else if(line.contains("*")){
                String result = String.valueOf(Integer.parseInt(split[0])*Integer.parseInt(split[1]));
                line = line+result;
            }
            System.out.println(line);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

