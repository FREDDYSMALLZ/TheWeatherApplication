package com.fredrick.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean
@ViewScoped
@XmlRootElement(
        name = "Weather"
)
public class Weather {
    String day;
    int high;
    int low;
    String forecast;

    public Weather() {
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getHigh() {
        return this.high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return this.low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public String getForecast() {
        return this.forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public Weather(String day, int high, int low, String forecast) {
        this.day = day;
        this.high = high;
        this.low = low;
        this.forecast = forecast;
    }
}

