package com.dl.jeudesensah.web.Lisners;

import com.dl.jeudesensah.Beans.User;
import com.dl.jeudesensah.database.DataBaseFactory;
import com.dl.jeudesensah.database.mysqlDb.DaoFactory;
import com.dl.jeudesensah.database.userDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

@WebListener
public class ApplicationListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public ApplicationListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context initializing");
        ServletContext ctx = sce.getServletContext();
        userDao gameData = null;
        String databaseType = null;
        try {
            Properties properties = DaoFactory.loadProperties();
            databaseType = properties.getProperty("database.type");
            gameData = DataBaseFactory.getFactory(databaseType, ctx);
            ctx.setAttribute("gameData", gameData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("context initialized");
        List<User> userList = Collections.synchronizedList(new ArrayList<User>());
        ctx.setAttribute("users", userList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
    }
}
