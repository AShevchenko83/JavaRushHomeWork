package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно,
инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if(!(args[0].equals("-c"))) return;
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line=null;
        int maxId=0;
        while (!((line=fileReader.readLine())==null))
        {
            int curId = 0;
            int endOfNum = 0;
            for (int i = 0; i < 8; i++)
            {
                if(!Character.isDigit(line.charAt(i)))
                {
                    endOfNum = i;
                    break;
                }
                if(i==7) endOfNum =8;
            }
            curId =  Integer.parseInt(line.substring(0,endOfNum));
            if (curId>maxId) maxId=curId;
        }
        maxId++;
        fileReader.close();
        String idToAdd = Integer.toString(maxId);
        int targetLength = 8;
        int curLenght = idToAdd.length();
        for (int i = 0; i <(targetLength-curLenght) ; i++)
        {
            idToAdd = idToAdd + " ";
        }
        targetLength=30;
        String nameToAdd=null;
        if(args[1].length()<=30) nameToAdd= args[1];
        else nameToAdd= args[1].substring(0,30);
        curLenght = nameToAdd.length();
        for (int i = 0; i < (targetLength-curLenght); i++)
        {
            nameToAdd = nameToAdd+ " ";
        }
        targetLength = 8;
        String priceToAdd=null;
        if( args[2].length()<=8) priceToAdd = args[2];
        else priceToAdd= args[2].substring(0,8);
        curLenght = priceToAdd.length();
        for (int i = 0; i < (targetLength-curLenght); i++)
        {
            priceToAdd = priceToAdd+ " ";
        }
        targetLength = 4;
        String quantToAdd=null;
        if( args[3].length()<=4) quantToAdd = args[3];
        else quantToAdd = args[3].substring(0,4);
        curLenght = quantToAdd.length();
        for (int i = 0; i < (targetLength-curLenght); i++)
        {
            quantToAdd = quantToAdd+" ";
        }
        String lineToAdd = idToAdd+nameToAdd+priceToAdd+quantToAdd;
        BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName,true), "utf-8"));
        writer.write(lineToAdd);
        writer.close();

    }
}
