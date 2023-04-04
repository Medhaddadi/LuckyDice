package com.dl.jeudesensah.database;

import com.dl.jeudesensah.database.contextDb.userDaoContimp;
import com.dl.jeudesensah.database.mysqlDb.DaoFactory;
import com.dl.jeudesensah.database.mysqlDb.userDaoMysqlImpl;
import jakarta.servlet.ServletContext;

import java.io.IOException;

public class DataBaseFactory {
    public static userDao getFactory(String type, ServletContext ctx) throws IOException {
        if (type.equals("mysql")) {
            System.out.println("database type: mysql is selected");
            return new userDaoMysqlImpl(DaoFactory.getInstance());
        }
        System.out.println("database type: context  is selected");
        return new userDaoContimp(ctx);
    }
}
