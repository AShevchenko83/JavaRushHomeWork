package com.javarush.test.level24.lesson02.home01;

/**
 * Created by Admin on 31.07.16.
 */
public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker
{
    String str;

    public SelfInterfaceMarkerImpl() {
        str = "str";
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
