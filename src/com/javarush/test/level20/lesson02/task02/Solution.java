package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            String numberOfUsers = Integer.valueOf(users.size()).toString();
            writer.println(numberOfUsers);
            for (int i = 0; i < users.size(); i++) {
                String isFirstName = users.get(i).getFirstName()!=null? "yes": "no";
                writer.println(isFirstName);
                if(users.get(i).getFirstName()!=null){
                    writer.println(users.get(i).getFirstName());
                }
                String isSecondName = users.get(i).getLastName()!=null? "yes": "no";
                writer.println(isSecondName);
                if(users.get(i).getLastName()!=null){
                    writer.println(users.get(i).getLastName());
                }
                String isDate = users.get(i).getBirthDate()!=null? "yes": "no";
                writer.println(isDate);
                if (users.get(i).getBirthDate()!=null){
                    String date = Long.valueOf(users.get(i).getBirthDate().getTime()).toString();
                    writer.println(date);
                }
                writer.println(users.get(i).isMale());
                String isCountry = users.get(i).getCountry()!=null? "yes": "no";
                writer.println(isCountry);
                if(users.get(i).getCountry()!=null){
                    String country="";
                    if(users.get(i).getCountry()== User.Country.OTHER){
                        country = "Other";
                    }
                    else if(users.get(i).getCountry()== User.Country.RUSSIA){
                        country = "Russia";
                    }
                    else if(users.get(i).getCountry()== User.Country.UKRAINE){
                        country = "Ukraine";
                    }
                    else if(users.get(i).getCountry().getDisplayedName()!=null){
                        country = users.get(i).getCountry().getDisplayedName();
                    }
                    writer.println(country);
                }

            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int numberOfUsers = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numberOfUsers; i++) {
                User user = new User();
                String isFirstName = reader.readLine();
                if(isFirstName.equals("yes")){
                    user.setFirstName(reader.readLine());
                }
                String isSecondName = reader.readLine();
                if(isSecondName.equals("yes")){
                    user.setLastName(reader.readLine());
                }
                String isDate = reader.readLine();
                if (isDate.equals("yes")){
                    user.setBirthDate(new Date(Long.valueOf(reader.readLine())));
                }
                String sex = reader.readLine();
                if(sex.equals("true")){
                    user.setMale(true);
                }
                else {
                    user.setMale(false);
                }
                String isCountry = reader.readLine();
                if(isCountry.equals("yes")){
                    String country = reader.readLine();
                    switch (country){
                        case "Other":
                            user.setCountry(User.Country.OTHER);
                            break;
                        case "Russia":
                            user.setCountry(User.Country.RUSSIA);
                            break;
                        case "Ukraine":
                            user.setCountry(User.Country.UKRAINE);
                            break;
                    }
                }

                users.add(user);
            }

        }
    }
}
