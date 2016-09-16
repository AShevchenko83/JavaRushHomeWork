package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id,
и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file = reader.readLine();
            reader.close();
            int param = Integer.parseInt(args[0]);
            BufferedReader filereader = new BufferedReader(new FileReader(file));
            String[] line = null;
            String str= null;
            while (filereader.ready())
            {
                str= filereader.readLine();
                line = str.split(" ");
                int index = Integer.parseInt(line[0]);
                if(index==param) System.out.println(str);
            }
            filereader.close();
        }
        catch (IOException e) {}
    }
}
