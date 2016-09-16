package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали
конструкторам класса Solution.
*/

public class Solution
{
    public Solution() {}

    public Solution(int n) {}

    public Solution(String s) {}

    Solution(int n, int m) {}

    Solution(String s, int n) {}

    Solution(String s, String t, int n) {}

    protected Solution(char c) {}

    protected Solution(int n, char c) {}

    protected Solution(String s, char c) {}

    private Solution(char c, char d) {}

    private Solution(int n, char c, char d) {}

    private Solution(String s, char c, char d) {}
}


