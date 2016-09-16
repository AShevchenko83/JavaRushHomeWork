package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

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
    public static void main(String[] args) throws IOException{
        if(args[0].equals("-u")) upDate(args);
        if(args[0].equals("-d")) delete(args);

    }

    public static int findIndexOfLine (int id, String fileName) throws IOException
    {
        BufferedReader fileReader= new BufferedReader(new FileReader(fileName));
        try
        {
            String line=null;
            for (int j =0 ;!((line=fileReader.readLine())==null); j++)
            {
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
                int curId =  Integer.parseInt(line.substring(0,endOfNum));
                if (id==curId) return j;
            }
            return -1;
        }
        finally
        {
            fileReader.close();
        }
    }

    public static String lineToAdd(String[] args)
    {
        String idToAdd = null;
        int targetLength = 8;
        if(args[1].length()<=8) idToAdd=args[1];
        else idToAdd = args[1].substring(0,8);
        int curLenght = idToAdd.length();
        for (int i = 0; i <(targetLength-curLenght) ; i++)
        {
            idToAdd = idToAdd + " ";
        }
        targetLength=30;
        String nameToAdd=null;
        if(args[2].length()<=30) nameToAdd= args[2];
        else nameToAdd= args[2].substring(0,30);
        curLenght = nameToAdd.length();
        for (int i = 0; i < (targetLength-curLenght); i++)
        {
            nameToAdd = nameToAdd+ " ";
        }
        targetLength = 8;
        String priceToAdd=null;
        if( args[3].length()<=8) priceToAdd = args[3];
        else priceToAdd= args[3].substring(0,8);
        curLenght = priceToAdd.length();
        for (int i = 0; i < (targetLength-curLenght); i++)
        {
            priceToAdd = priceToAdd+ " ";
        }
        targetLength = 4;
        String quantToAdd=null;
        if( args[4].length()<=4) quantToAdd = args[4];
        else quantToAdd = args[4].substring(0,4);
        curLenght = quantToAdd.length();
        for (int i = 0; i < (targetLength-curLenght); i++)
        {
            quantToAdd = quantToAdd+" ";
        }
        String lineToAdd = idToAdd+nameToAdd+priceToAdd+quantToAdd+ "\n";
        return lineToAdd;
    }

    public static void upDate (String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
        reader.close();
            BufferedReader fileReader =
                    new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"utf-8"));
                String buffer= "";
                String lineToAdd= lineToAdd(args);
                int indexOfLine= findIndexOfLine(Integer.parseInt(args[1]),fileName);
                String lineToBuffer=null;
                for (int i = 0; !((lineToBuffer=fileReader.readLine())==null); i++)
                {
                    if(i!=indexOfLine)
                    {
                        buffer= buffer+lineToBuffer;
                        if(fileReader.ready()) buffer= buffer+"\n";
                    }
                    else buffer= buffer+lineToAdd;
                }
            fileReader.close();
        BufferedWriter fileWriter =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"));
                fileWriter.write(buffer);
            fileWriter.close();

        //"utf-8"
        //"Cp1251"


    }

    public  static void delete (String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader =
                new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"utf-8"));
        String buffer= "";
        int indexOfLine= findIndexOfLine(Integer.parseInt(args[1]),fileName);
        String lineToBuffer=null;
        for (int i = 0; !((lineToBuffer=fileReader.readLine())==null); i++)
        {
            if(i!=indexOfLine)
            {
                buffer= buffer+lineToBuffer;
                if(fileReader.ready()) buffer= buffer+"\n";
            }
        }
        fileReader.close();
        BufferedWriter fileWriter =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"));
        fileWriter.write(buffer);
        fileWriter.close();
    }
}
