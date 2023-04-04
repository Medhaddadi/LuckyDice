package com.dl.jeudesensah.database.mysqlDb;

import com.dl.jeudesensah.database.contextDb.userDaoContimp;
import com.dl.jeudesensah.database.userDao;
import jakarta.servlet.ServletContext;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {
    private String url;
    private String username;
    private String password;

    DaoFactory() throws IOException {
        Properties props = loadProperties();
        this.url = props.getProperty("database.url");
        this.username = props.getProperty("database.username");
        this.password = props.getProperty("database.password");
        System.out.println("url: " + url);
        System.out.println("username: " + username);
        System.out.println("password: " + password);

    }

    public static DaoFactory getInstance() throws IOException {
        try {
            Properties props = loadProperties();
            String driver = props.getProperty("database.driver");
            Class.forName(driver);
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Driver not found" + e.getMessage());
        }
        return new DaoFactory();
    }

    public Connection getConnection() {
        try {
            System.out.println("We are connected to the database");
            System.out.println("url: " + url);
            System.out.println("username: " + username);
            System.out.println("password: " + password);
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("We can't connect to the database");
        }
        return null;
    }

    public static Properties loadProperties() throws IOException {
        Properties props = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream resourceStream = loader.getResourceAsStream("config.properties");
        props.load(resourceStream);
        return props;
    }

    public userDao getUserDao() {
        return new userDaoMysqlImpl(this);
    }
}
