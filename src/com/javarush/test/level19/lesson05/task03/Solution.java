package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1= reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
        while (bufferedReader.ready()){
            String[] line = bufferedReader.readLine().split("[., !?;:-]");
            for (String str: line) {
                boolean isDigit = true;
                for (int i=0; i<str.length(); i++){
                    if(!Character.isDigit(str.charAt(i))) isDigit=false;
                }
                if(isDigit) bufferedWriter.write(str+ " ");
            }
        }
        bufferedReader.close();
        bufferedWriter.close();

    }
}
