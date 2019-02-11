package com.fredrick.businessLogic;

import com.fredrick.beans.Weather;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import java.util.ArrayList;

@Stateless
@Local
@Alternative
public abstract class BusinessServiceInterface {
    public abstract int deleteOne(String var1);

    public abstract int insertOne(Weather var1);

    public abstract ArrayList<Weather> readAll();

    public abstract int updateOne(String var1, Weather var2);
}

