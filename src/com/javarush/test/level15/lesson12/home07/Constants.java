package com.javarush.test.level15.lesson12.home07;

/* Файл в статическом блоке
1. Инициализируй константу Constants.FILE_NAME полным путем к файлу с данными,
который содержит несколько строк.
2. В статическом блоке считай из файла с именем Constants.FILE_NAME все строки и
добавь их по-отдельности в List lines.
3. Закрой поток ввода методом close().
*/

public class Constants {
    public static String FILE_NAME = "D:\\in.txt";
}
