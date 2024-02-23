package com.example.java_fx_2024_l3gl.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Bd {

    private final String server= "localhost";
    private final String username = "root";
    private final String password = "";
    private final String bd = "gl3_2024";
    private final String url = ""
            + "jdbc:mysql://"+server+":3306/"+bd;
    private Connection conn;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url, username, password);
            System.out.println("Connecté");
        } catch (Exception ex) {
            conn=null;
            System.out.print("Erreur");
        }
        return conn;
    }

}
