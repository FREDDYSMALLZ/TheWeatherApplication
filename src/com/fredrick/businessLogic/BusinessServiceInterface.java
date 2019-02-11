package com.fredrick.businessLogic;

import com.fredrick.beans.Weather;
import java.util.ArrayList;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

@Stateless
@Local
@Alternative
public interface BusinessServiceInterface {
    int deleteOne(String var1);

    int insertOne(Weather var1);

    ArrayList<Weather> readAll();

    int updateOne(String var1, Weather var2);
}

