package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы.
Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer= customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode()
        {
            /*for (Map.Entry<String, String> pair: countries.entrySet()                 )
            {
                if (pair.getValue().equals(customer.getCountryName()))
                    return pair.getValue();
            }
            return "Нет такой страны.";*/
            String countryName=customer.getCountryName();
            String countryCode=null;
            for(Map.Entry<String, String> a: countries.entrySet()){
                if (a.getValue().equals(countryName)){
                    countryCode=a.getKey();
                }
            }
            return countryCode;
        }

        @Override
        public String getCompany()
        {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            String[] split = contact.getName().split(" ");
            return split[1];
        }

        @Override
        public String getContactLastName()
        {
            String[] split = contact.getName().split(", ");
            return split[0];
        }

        @Override
        public String getDialString()
        {
            /*int lenght = contact.getPhoneNumber().length();
            String strnum= contact.getPhoneNumber();
            StringBuilder number = new StringBuilder(strnum.substring(0, lenght-14 ));
               number.append(strnum.substring(lenght-13,lenght-10)).
                       append(strnum.substring(lenght-9,lenght-6)).
                       append(strnum.substring(lenght-5,lenght-3)).
                       append(strnum.substring(lenght-2));
            return "callto://"+number.toString();*/
            return "callto://+" + contact.getPhoneNumber().replaceAll("[^0-9]", "");

        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}