package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);
        String[] arr = new String[tokenizer.countTokens()];
        int count = 0;
        while (tokenizer.hasMoreTokens()){
            arr[count]=tokenizer.nextToken();
            count++;
        }
        return arr;
    }
}
