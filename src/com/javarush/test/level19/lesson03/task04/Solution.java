package com.javarush.test.level19.lesson03.task04;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей,
данные одного человека находятся в одной строке.
Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            String[] person = scanner.nextLine().split(" ");
            GregorianCalendar calendar =
                    new GregorianCalendar(Integer.parseInt(person[5]), Integer.parseInt(person[4]) - 1,
                            Integer.parseInt(person[3]));
            Person pers = new Person(person[1], person[2], person[0], calendar.getTime());
            return pers;
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}
