package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Admin on 06.09.16.
 */
public class Controller
{
    private Provider[] providers;
    public Controller(Provider... providers) {
        if(providers == null || providers.length == 0) throw new IllegalArgumentException();
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan()
    {
        ArrayList<Vacancy> list = new ArrayList<>();
        for (Provider provider: providers){
            try {
                for (Vacancy vacancy: provider.getJavaVacancies("Kiev")){
                    list.add(vacancy);
                }
            } catch (Exception e) {}
        }
        System.out.println(list.size());
    }
}
