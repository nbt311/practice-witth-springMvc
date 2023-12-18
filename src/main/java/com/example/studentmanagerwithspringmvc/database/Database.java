package com.example.studentmanagerwithspringmvc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    protected String jbdcUrl;
    protected String jbdUsername;
    protected String jbdPassword;

    public static Database instance;

    public Database() {
        this.jbdcUrl = "jdbc:mysql://localhost:3306/demotest?allowPublicKeyRetrieval=true&useSSL=false";
        this.jbdUsername = "root";
        this.jbdPassword = "123456";
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(jbdcUrl,jbdUsername,jbdPassword);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage() + "Error");
        }
        return null;
    }
}
