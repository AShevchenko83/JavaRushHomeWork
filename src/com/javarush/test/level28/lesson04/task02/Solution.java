package com.javarush.test.level28.lesson04.task02;

import java.util.concurrent.ThreadLocalRandom;

/* ThreadLocalRandom
Класс Solution будет использоваться трэдами.
Реализуйте логику всех методов, используйте класс ThreadLocalRandom.
getRandomIntegerBetweenNumbers должен возвращать случайный int между from и to
getRandomDouble должен возвращать случайный double
getRandomLongBetween0AndN должен возвращать случайный long между 0 и n
*/
public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(from, to);
    }

    public static double getRandomDouble() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n) {

        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextLong(0,n);
    }
}
