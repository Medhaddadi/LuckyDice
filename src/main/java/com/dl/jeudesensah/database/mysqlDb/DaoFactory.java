package com.dl.jeudesensah.database.mysqlDb;

import com.dl.jeudesensah.database.contextDb.userDaoContimp;
import com.dl.jeudesensah.database.userDao;
import jakarta.servlet.ServletContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        }
        return new DaoFactory("jdbc:mysql://localhost:3306/jeuDesEnsah", "root", "");
    }

    public static userDao getFactory(String type, ServletContext ctx) {
        if (type.equals("mysqlDb")) {
            System.out.println("database type: mysql is selected");
            return new userDaoMysqlImpl(getInstance());
        }
        System.out.println("database type: context  is selected");
            return new userDaoContimp(ctx);
    }

    public Connection getConnection(){
        try {
            return DriverManager.getConnection(url, username, password);
        }catch (SQLException e){
            System.out.println("We can't connect to the database");
        }
        return null;
    }

    // Récupération du Dao
    public userDao getUserDao() {

        return new userDaoMysqlImpl(this);
    }
}
