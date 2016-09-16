package com.javarush.test.level26.lesson15.big01;

;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 15.08.16.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){

        if(denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination,count);
    }

    public int getTotalAmount(){
        int summa=0;
        for (Map.Entry<Integer, Integer> pair:denominations.entrySet() )
        {
            summa+=(pair.getKey()*pair.getValue());
        }
        return summa;
    }

    public boolean hasMoney(){
        return getTotalAmount()>0;
    }

    public boolean isAmountAvailable(int expectedAmount){
        if(!hasMoney()) return false;
        else return expectedAmount <= getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount)throws NotEnoughMoneyException
    {
        if(!isAmountAvailable(expectedAmount)) throw new NotEnoughMoneyException();
        ArrayList<Integer> list = new ArrayList<>(denominations.keySet());
        Collections.sort(list);
        Map<Integer,Integer> returnMap = null;
        returnMap = retMap(list, list.get(list.size()-1), expectedAmount);
        if(returnMap!=null){
            for (Map.Entry<Integer, Integer> pair: returnMap.entrySet()                 )
            {
                if(denominations.containsKey(pair.getKey())){
                    if(denominations.get(pair.getKey())==pair.getValue()) denominations.remove(pair.getKey());
                    else {
                        denominations.put(pair.getKey(), denominations.get(pair.getKey())-pair.getValue());
                    }
                }
            }
            return returnMap;
        }
        throw new RuntimeException();
    }

    private Map<Integer, Integer> retMap (ArrayList<Integer> list, int nomin, int amount){
        Map<Integer,Integer> map = new HashMap<>();
        if(nomin*denominations.get(Integer.valueOf(nomin))>=amount&&(amount%nomin==0)) {
            map.put(Integer.valueOf(nomin), Integer.valueOf(amount/nomin));
            return map;
        }
        else if(nomin*denominations.get(nomin)>amount){
            if (list.indexOf(Integer.valueOf(nomin))==0) return null;
            for (int i = amount/nomin; i >=1 ; i--)
            {
                int newNomin = list.get(list.indexOf(Integer.valueOf(nomin))-1);
                int newAmount = amount-nomin*i;
                Map<Integer,Integer> newMap = null;
                newMap=retMap(list,newNomin, newAmount);
                if(newMap!=null) {
                    map.put(nomin, i);
                    map.putAll(newMap);
                    return map;
                }
            }
            int newNomin = list.get(list.indexOf(Integer.valueOf(nomin))-1);
            int newAmount = amount;
            Map<Integer,Integer> newMap = null;
            newMap=retMap(list,newNomin, newAmount);
            if (newMap!=null){
                map.putAll(newMap);
                return map;
            }
        }
        else  if (amount>nomin){
            if (list.indexOf(Integer.valueOf(nomin))==0) return null;
            for (int i = denominations.get(Integer.valueOf(nomin)); i >=1 ; i--)
            {
                int newNomin = list.get(list.indexOf(Integer.valueOf(nomin))-1);
                int newAmount = amount-nomin*i;
                Map<Integer,Integer> newMap = null;
                newMap=retMap(list,newNomin, newAmount);
                if(newMap!=null) {
                    map.put(nomin, i);
                    map.putAll(newMap);
                    return map;
                }
            }
            int newNomin = list.get(list.indexOf(Integer.valueOf(nomin))-1);
            int newAmount = amount;
            Map<Integer,Integer> newMap = null;
            newMap=retMap(list,newNomin, newAmount);
            if (newMap!=null){
                map.putAll(newMap);
                return map;
            }
        }
        return null;
    }



}
