package com.fredrick.controllers;

import com.fredrick.DbConnections.DbService;
import com.fredrick.DbConnections.UserDbService;
import com.fredrick.beans.User;
import com.fredrick.beans.Weather;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.sql.SQLException;
import java.util.ArrayList;

@ManagedBean
public class FormController {
    public String onSubmitEdit() throws SQLException {
        System.out.println("Clicked the submit button on entry form");
        FacesContext context = FacesContext.getCurrentInstance();
        User u = (User)context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
        UserDbService uds = new UserDbService();
        uds.insertOne(u);
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", u);
        return "ResponsePage.xhtml";
    }

    public FormController() {
    }

    public ArrayList<Weather> fetchAll() throws SQLException {
        DbService ds = new DbService();
        return ds.readAll();
    }
}

