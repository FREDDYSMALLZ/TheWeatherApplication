package com.fredrick.businessLogic;

import com.fredrick.DbConnections.DbInterface;
import com.fredrick.beans.Weather;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.ArrayList;

@Local
@Stateless
@Alternative
public class BusinessService implements BusinessServiceInterface {
    @Inject
    DbInterface db;

    public BusinessService() {
    }

    public int deleteOne(String day) {
        return this.db.deleteOne(day);
    }

    public int insertOne(Weather w) {
        return this.db.insertOne(w);
    }

    public ArrayList<Weather> readAll() {
        return this.db.readAll();
    }

    public int updateOne(String day, Weather w) {
        return this.db.updateOne(day, w);
    }
}

