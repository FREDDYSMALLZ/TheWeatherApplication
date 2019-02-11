package com.fredrick.beans;

import java.util.ArrayList;
import java.util.Iterator;

public class WeatherItems {
    ArrayList<Weather> theList = new ArrayList();

    public WeatherItems() {
    }

    public void add(Weather w) {
        this.theList.add(w);
    }

    public void printAll() {
        System.out.println("Current Weather Forecast: ");

        for (Weather w : this.theList) {
            System.out.println("Day: " + w.day + " High: " + w.high + " Low: " + w.low + " Forecast: " + w.forecast);
        }

    }
}

