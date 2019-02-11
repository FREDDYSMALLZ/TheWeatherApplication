package com.fredrick.DbConnections;

import com.fredrick.beans.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDbService {
    String dbURL = "jdbc:mysql://localhost:3306/WeatherDb";
    String user = "root";
    String password = "password";
    Connection con = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    int rowsAffected = 0;
    int numberOfRowsAffected = 0;

    public UserDbService() {
    }

    public int deleteOne(String username) throws SQLException {
        try {
            this.con = DriverManager.getConnection(this.dbURL, this.user, this.password);
            System.out.println("Connection is successful! " + this.dbURL);
            this.pstmt = this.con.prepareStatement("delete from WeatherDb.user where name = ?");
            this.pstmt.setString(1, username);
            this.rowsAffected = this.pstmt.executeUpdate();
            System.out.println("Rows affected: " + this.rowsAffected);
        } catch (SQLException var6) {
            System.out.println("Error communicating with the database: " + this.dbURL);
            var6.printStackTrace();
        } finally {
            this.pstmt.close();
            this.con.close();
        }

        return this.numberOfRowsAffected;
    }

    public int insertOne(User user) throws SQLException {
        try {
            this.con = DriverManager.getConnection(this.dbURL, this.user, this.password);
            System.out.println("Connection is successful! " + this.dbURL);
            this.pstmt = this.con.prepareStatement("insert into WeatherDb.userTbl (username, email, location, password) values (?, ?, ?, ?)");
            this.pstmt.setString(1, user.getUsername());
            this.pstmt.setString(2, user.getEmail());
            this.pstmt.setString(3, user.getLocation());
            this.pstmt.setString(4, user.getPassword());

            this.rowsAffected = this.pstmt.executeUpdate();
            System.out.println("Rows inserted: " + this.rowsAffected);
        } catch (SQLException var6) {
            System.out.println("Error communicating with the database: " + this.dbURL);
            var6.printStackTrace();
        } finally {
            this.pstmt.close();
            this.con.close();
        }

        return this.numberOfRowsAffected;
    }

    public ArrayList<User> ReadAll() throws SQLException {
        ArrayList everything = new ArrayList();

        try {
            this.con = DriverManager.getConnection(this.dbURL, this.user, this.password);
            System.out.println("Connection is successful! " + this.dbURL);
            this.stmt = this.con.createStatement();
            this.rs = this.stmt.executeQuery("select * from WeatherDb.userTbl");

            while (this.rs.next()) {
                System.out.println("User Name: " + this.rs.getString("name") + " Password " + this.rs.getString("password") + " Location: " + this.rs.getString("location"));
                User u = new User(this.rs.getString("username"), this.rs.getString("email"),
                        this.rs.getString("location"), this.rs.getString("password"));
                everything.add(u);
            }
        } catch (SQLException var7) {
            System.out.println("Error communicating with the database: " + this.dbURL);
            var7.printStackTrace();
        } finally {
            this.rs.close();
            this.stmt.close();
            this.con.close();
        }

        return everything;
    }

    public int updateOne(String name, User u) throws SQLException {
        try {
            this.con = DriverManager.getConnection(this.dbURL, this.user, this.password);
            System.out.println("Connection is successful! " + this.dbURL);
            this.pstmt = this.con.prepareStatement("update WeatherDb.userTbl password = ?, location = ? where name = ? ");
            this.pstmt.setString(1, u.getPassword());
            this.pstmt.setString(2, u.getLocation());
            this.pstmt.setString(3, name);
            this.rowsAffected = this.pstmt.executeUpdate();
            System.out.println("Rows affected: " + this.rowsAffected);
        } catch (SQLException var7) {
            System.out.println("Error communicating with the database: " + this.dbURL);
            var7.printStackTrace();
        } finally {
            this.pstmt.close();
            this.con.close();
        }

        return this.numberOfRowsAffected;
    }
}

