package com.fredrick.businessLogic;

import com.fredrick.beans.Weather;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@RequestScoped
@Path("/Weather")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public class WeatherRestService {
    @Inject
    BusinessServiceInterface bs;

    public WeatherRestService() {
    }

    @GET
    @Path("/getxml")
    @Produces({"application/xml"})
    public List<Weather> getAllAsJson() {
        return this.bs.readAll();
    }

    @GET
    @Path("/getjson")
    @Produces({"application/json"})
    public Weather[] getAllAsXml() {
        List<Weather> w = this.bs.readAll();
        return (Weather[])w.toArray(new Weather[w.size()]);
    }
}

