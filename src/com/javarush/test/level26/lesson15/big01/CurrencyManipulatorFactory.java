package com.javarush.test.level26.lesson15.big01;

import java.util.*;

/**
 * Created by Admin on 15.08.16.
 */
public class CurrencyManipulatorFactory
{
    private static Map<String,CurrencyManipulator> manipulators = new HashMap<>();
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        for (CurrencyManipulator cm: manipulators.values()   )
        {
            if(cm.getCurrencyCode().equals(currencyCode)) return cm;
        }
        CurrencyManipulator manip= new CurrencyManipulator(currencyCode);
        manipulators.put(currencyCode, manip);
        return manip;
    }

    private CurrencyManipulatorFactory() {
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return manipulators.values();
    }
}
