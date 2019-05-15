package uk.ac.ucl.data;

import java.sql.*;

public class DbAdapter {

    private String jdbUrl;
    private String username;
    private String password;

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public DbAdapter(){
    }
    public void setjdbUrl(String url){
        this.jdbUrl = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void connect () throws SQLException{
        conn = DriverManager.getConnection(jdbUrl, username, password);
        System.out.println("Database connection established.");
    }

    public void disconnect(){
        try{
            if(stmt!=null){
                stmt.close();
            }
            if(rs!=null){
                rs.close();
            }
            if(conn!=null){
                conn.close();
            }
        }catch (Exception e){
            System.out.println("Disconnection failed.");
        }
    }
}