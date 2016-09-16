package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном,
 так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String nextWord = words[i];
            Word foundWord = findWord(nextWord, crossword);
            list.add(foundWord);
        }
        for (Word w: list) {
            System.out.println(w);
        }
        return list;
    }

    public  static Word findWord(String str, int[][] crossword){
        Word word = new Word(str);
        lebel:
        for (int i =0; i< crossword.length; i++){
            for (int j=0 ; j< crossword[i].length; j++){
                if(str.charAt(0)==crossword[i][j]){
                    int[] endWord = scanerRound(i,j,str,crossword);
                    if(endWord[0]>-1){
                        word.setStartPoint(j,i);
                        word.setEndPoint(endWord[1],endWord[0]);
                        break lebel;
                    }
                }
            }
        }
        return word;
    }

    public static int[] scanerRound (int row, int colon, String str, int[][] crossword){
        int[] ret = {-1,-1};
        int diffRow=0;
        int diffColon=0;
        lebel:
        for (int i = -1; i <2 ; i++) {
            for (int j = -1; j <2 ; j++) {
                if(i==0&&j==0)continue;
                if(row+i<0||row+i>crossword.length-1||colon+j<0||colon+j>crossword[row].length-1){
                    continue;
                }
                if(str.charAt(1)==(char)crossword[row+i][colon+j]){
                    if(str.length()==2){ //если слово из 2х букв
                        ret[0]=row+i;
                        ret[1]=colon+j;
                        break lebel;
                    }
                    diffRow = i;
                    diffColon=j;
                    int[] endLine  = scanerLine(row+i,colon+j, diffRow,diffColon, str,crossword);
                    if(endLine[0]==-1){
                        diffRow=0;
                        diffColon=0;
                        continue ;
                    }
                    ret[0]= endLine[0];
                    ret[1] = endLine[1];
                    break lebel;
                }
            }
        }

        return ret;
    }

    public static int[] scanerLine( int row2, int colon2, int diffRow, int diffColon,
                                    String str, int[][] crossword){
        int[] ret= {-1,-1};
        int currRow= row2;
        int currColon = colon2;
        for (int i = 2; i <str.length() ; i++) {
            if(currRow+diffRow<0||currRow+diffRow>crossword.length-1||
                    currColon+diffColon<0||currColon+diffColon>crossword[row2].length){
                return ret;
            }
            if (str.charAt(i) != (char) crossword[currRow+diffRow][currColon+diffColon]){
                return ret;
            }
            else {
                currRow+=diffRow;
                currColon+=diffColon;
            }
        }
        ret[0]= currRow;
        ret[1] = currColon;
        return ret;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
