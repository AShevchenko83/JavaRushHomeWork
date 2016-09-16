package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException{
            BufferedReader reader1 =
                    new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader1.readLine();
            String file2 = reader1.readLine();
            reader1.close();
            BufferedReader filereader1=
                    new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
            BufferedReader filereader2=
                    new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
            ArrayList<String> list1 = new ArrayList<>();
            ArrayList<String> list2= new ArrayList<>();
            while (filereader1.ready()){
                list1.add(filereader1.readLine());
            }
            while (filereader2.ready()){
                list2.add(filereader2.readLine());
            }
            filereader1.close();
            filereader2.close();
            for (int i = 0; i < list1.size(); i++) {
                if(i<list2.size()&&!(list1.get(i).equals(list2.get(i)))){
                    if(i+1<list2.size()&&list1.get(i).equals(list2.get(i+1))){
                        list1.add(i,"");
                    }
                    else if(i+1<list1.size()&& list1.get(i+1).equals(list2.get(i))){
                        list2.add(i,"");
                    }
                }
            }
            //System.out.println(list1.size()+ " "+ list2.size());
            if(list1.size()>list2.size()) list2.add("");
            else if (list2.size()>list1.size()) list1.add("");
            //System.out.println(list1.size()+ " "+ list2.size());
            for (int i = 0; i < list1.size(); i++) {
                if(list1.get(i).equals(list2.get(i))) lines.add(new LineItem(Type.SAME,list1.get(i)));
                else if(list1.get(i).equals("")) lines.add(new LineItem(Type.ADDED,list2.get(i)));
                else if(list2.get(i).equals("")) lines.add(new LineItem(Type.REMOVED,list1.get(i)));
            }

            /*for (int i = 0; i < lines.size(); i++) {
                System.out.println(lines.get(i).type+ " "+ lines.get(i).line);
            }*/

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
