package com.fredrick.DbConnections;

import com.fredrick.beans.Weather;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface DbInterface {
    int deleteOne(String var1);

    int insertOne(Weather var1);

    ArrayList<Weather> readAll();

    int updateOne(String var1, Weather var2);
}

