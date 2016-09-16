package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties
данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();



    public void fillInPropertiesMap() throws Exception{
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        InputStream inputStream = new FileInputStream(fileName);
        load(inputStream);
        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties saveProperties = new Properties(); //создаем properties
        for (Map.Entry<String, String> prop : properties.entrySet()) { //проходимся по mape
            saveProperties.setProperty(prop.getKey(), prop.getValue());//сохраняем данные в наш new prop
        }
        saveProperties.save(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        properties=new HashMap<>();
        while (reader.ready()){
            String line = reader.readLine();
            if (line.substring(0,1).equals("#")||line.substring(0,1).equals("!")) continue;
            else {
                int endOfKey=0;
                int startOfValue=0;
                String key=null;
                String value = null;
                for (int i = 1; i<line.length(); i++){
                    if((line.substring(i,i+1).equals(" ")|| line.substring(i,i+1).equals("=")||
                    line.substring(i,i+1).equals(":"))&&
                            !line.substring(i-1,i).equals("\\") &&endOfKey==0){
                        endOfKey=i;
                    }
                    if(endOfKey!=0&&!line.substring(i,i+1).equals(" ")&&
                            !line.substring(i,i+1).equals("=")&& !line.substring(i,i+1).equals(":")){
                        startOfValue=i;
                    }
                    key=line.substring(0,endOfKey);
                    if(line.substring(line.length()-1, line.length()).equals("\\")){
                        value=line.substring(startOfValue)+reader.readLine();
                    }
                    else {
                        value=line.substring(startOfValue);
                    }
                }
                properties.put(key,value);
            }
        }
        reader.close();*/
        Properties prop = new Properties();
        prop.load(inputStream);
        properties= new HashMap<String, String>((Map) prop);

    }
}
