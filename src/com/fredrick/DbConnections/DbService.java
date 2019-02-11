package com.fredrick.DbConnections;


import com.fredrick.beans.Weather;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import java.sql.*;
import java.util.ArrayList;

@Stateless
@Local
@Alternative
public class DbService implements DbInterface {
    String dbURL = "jdbc:mysql://localhost:3306/WeatherDb";
    String user = "root";
    String password = "password";
    Connection c = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    int rowsAffected = 0;
    int numberOfRowsAffected = 0;

    public DbService() {
    }

    public int deleteOne(String day) {
        try {
            this.c = DriverManager.getConnection(this.dbURL, this.user, this.password);
            System.out.println("Connection is successful! " + this.dbURL);
            this.pstmt = this.c.prepareStatement("delete from WeatherDb.weatherTbl where day = ?");
            this.pstmt.setString(1, day);
            this.rowsAffected = this.pstmt.executeUpdate();
            System.out.println("Rows affected: " + this.rowsAffected);
        } catch (SQLException var15) {
            System.out.println("Error communicating with the database: " + this.dbURL);
            var15.printStackTrace();
        } finally {
            try {
                this.pstmt.close();
            } catch (SQLException var14) {
                var14.printStackTrace();
            }

            try {
                this.c.close();
            } catch (SQLException var13) {
                var13.printStackTrace();
            }

        }

        return this.numberOfRowsAffected;
    }

    public int insertOne(Weather w) {
        try {
            this.c = DriverManager.getConnection(this.dbURL, this.user, this.password);
            System.out.println("Connection is successful! " + this.dbURL);
            this.pstmt = this.c.prepareStatement("insert into WeatherDb.weatherTbl (day, high, low, forecast) values (?, ?, ?, ?)");
            this.pstmt.setString(1, w.getDay());
            this.pstmt.setInt(2, w.getHigh());
            this.pstmt.setInt(3, w.getLow());
            this.pstmt.setString(4, w.getForecast());
            this.rowsAffected = this.pstmt.executeUpdate();
            System.out.println("Rows inserted: " + this.rowsAffected);
        } catch (SQLException var15) {
            System.out.println("Error communicating with the database: " + this.dbURL);
            var15.printStackTrace();
        } finally {
            try {
                this.pstmt.close();
            } catch (SQLException var14) {
                var14.printStackTrace();
            }

            try {
                this.c.close();
            } catch (SQLException var13) {
                var13.printStackTrace();
            }

        }

        return this.numberOfRowsAffected;
    }

    public ArrayList<Weather> readAll() {
        ArrayList everything = new ArrayList();

        try {
            this.c = DriverManager.getConnection(this.dbURL, this.user, this.password);
            System.out.println("Connection is successful! " + this.dbURL);
            this.stmt = this.c.createStatement();
            this.rs = this.stmt.executeQuery("select * from WeatherDb.weatherTbl");

            while(this.rs.next()) {
                System.out.println("Day: " + this.rs.getString("day") + " High: " + this.rs.getInt("high") + " Low: " + this.rs.getInt("low") + " Forecast: " + this.rs.getString("forecast"));
                Weather w = new Weather(this.rs.getString("day"), this.rs.getInt("high"), this.rs.getInt("low"), this.rs.getString("forecast"));
                everything.add(w);
            }
        } catch (SQLException var20) {
            System.out.println("Error communicating with the database: " + this.dbURL);
            var20.printStackTrace();
        } finally {
            try {
                this.rs.close();
            } catch (SQLException var19) {
                var19.printStackTrace();
            }

            try {
                this.stmt.close();
            } catch (SQLException var18) {
                var18.printStackTrace();
            }

            try {
                this.c.close();
            } catch (SQLException var17) {
                var17.printStackTrace();
            }

        }

        return everything;
    }

    public int updateOne(String day, Weather w) {
        try {
            this.c = DriverManager.getConnection(this.dbURL, this.user, this.password);
            System.out.println("Connection is successful! " + this.dbURL);
            this.pstmt = this.c.prepareStatement("update WeatherDb.weatherTbl set high = ?, low = ?, forecast = ? where day = ? ");
            this.pstmt.setInt(1, w.getHigh());
            this.pstmt.setInt(2, w.getLow());
            this.pstmt.setString(3, w.getForecast());
            this.pstmt.setString(4, day);
            this.rowsAffected = this.pstmt.executeUpdate();
            System.out.println("Rows affected: " + this.rowsAffected);
        } catch (SQLException var16) {
            System.out.println("Error communicating with the database: " + this.dbURL);
            var16.printStackTrace();
        } finally {
            try {
                this.pstmt.close();
            } catch (SQLException var15) {
                var15.printStackTrace();
            }

            try {
                this.c.close();
            } catch (SQLException var14) {
                var14.printStackTrace();
            }

        }

        return this.numberOfRowsAffected;
    }
}

