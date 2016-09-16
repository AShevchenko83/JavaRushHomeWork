package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег,
одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String file= reader.readLine();
        reader.close();
        BufferedReader filereader =
                new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder sb= new StringBuilder();
        while (filereader.ready()){
            String line = filereader.readLine();
            sb.append(line);
        }
        String str = sb.toString();
        filereader.close();
        String tegOn = "<"+args[0];
        String tegOff = "</"+ args[0]+ ">";
        int count = 0;
        ArrayList<Integer> on = new ArrayList<>();
        ArrayList<Integer> off =new ArrayList<>();
        while (count<str.length()&&str.indexOf(tegOn,count)>-1){
            int pos= str.indexOf(tegOn,count);
            if (str.substring((pos+tegOn.length()),(pos+tegOn.length()+1)).equals(" ")
                    ||str.substring((pos+tegOn.length()),(pos+tegOn.length()+1)).equals(">"))
            {

                on.add(pos);
            }
            count=pos+1;
        }
        count=0;
        while (count<str.length()&&str.indexOf(tegOff,count)>-1){
            int pos= str.indexOf(tegOff,count);
            off.add(pos);
            count=pos+1;
        }
        /*System.out.println(str);
        System.out.println(str.length());
        System.out.println(on);
        System.out.println(off);*/
        ArrayList<String> tegs =new ArrayList<>();

        cutTeg(str,tegOff,tegs,on,off);

        for (String s: tegs             ){
            System.out.println(s);
        }

    }

    public static void cutTeg( String str, String tegOff,
                               ArrayList<String> tegs, ArrayList<Integer> on, ArrayList<Integer> off){
        for (int i = 0; i < (on.size()-1); i++) {
            if(on.get(i+1)>off.get(i)){
                if ((off.get(i)+tegOff.length())<str.length()) {
                    tegs.add(str.substring(on.get(0), off.get(i)+tegOff.length()));
                }
                else tegs.add(str.substring(on.get(0)));
                //System.out.println("removeON "+on.get(0));
                //System.out.println("removeOFF "+off.get(i));
                on.remove(0);
                off.remove(i);
                i=-1;
                //System.out.println(on);
                //System.out.println(off);
            }
            if(on.size()>1&&i==(on.size()-2)&&on.get(i+1)<off.get(i)){
                if ((off.get(i+1)+tegOff.length())<str.length()) {
                    tegs.add(str.substring(on.get(0), off.get(i+1)+tegOff.length()));
                }
                else tegs.add(str.substring(on.get(0)));
                /*System.out.println("removeON "+on.get(0));
                System.out.println("removeOFF "+off.get(i+1));*/
                on.remove(0);
                off.remove(i+1);
                i=-1;
                /*System.out.println(on);
                System.out.println(off);*/
                cutTeg(str,tegOff,tegs,on,off);
            }
        }
        if (on.size()>0)
        {
            if ((off.get(0)+tegOff.length())<str.length()) {
                tegs.add(str.substring(on.get(0), off.get(0)+tegOff.length()));
                /*System.out.println("removeON "+on.get(0));
                System.out.println("removeOFF "+off.get(0));*/
                on.remove(0);
                off.remove(0);
                /*System.out.println(on);
                System.out.println(off);*/
                return;
            }
            else {
                tegs.add(str.substring(on.get(0)));
                /*System.out.println("removeON "+on.get(0));
                System.out.println("removeOFF "+off.get(0));*/
                on.remove(0);
                off.remove(0);
                /*System.out.println(on);
                System.out.println(off);*/
                return;
            }
        }
    }


}
