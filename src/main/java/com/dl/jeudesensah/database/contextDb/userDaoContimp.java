package com.dl.jeudesensah.database.contextDb;

import com.dl.jeudesensah.Beans.User;
import com.dl.jeudesensah.database.userDao;
import jakarta.servlet.ServletContext;

import java.util.ArrayList;
import java.util.List;

public class userDaoContimp implements userDao {


    private ServletContext conext;

    private static userDaoContimp instance;

    public userDaoContimp(ServletContext conext) {
        this.conext = conext;
    }

    synchronized public static userDaoContimp getInstance(ServletContext conext) {
        if (instance == null) {
            instance = new userDaoContimp(conext);
        }
        return instance;
    }

    @Override
    public boolean insertUser(User user) {
        if (getUserByLogin(user.getLogin()) != null) {
            // user already exists
            System.out.println("user already exists");
            return false;
        } else {
            if (conext.getAttribute("users") == null) {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                conext.setAttribute("users", userList);
            } else {
                List<User> userList = (List<User>) conext.getAttribute("users");
                userList.add(user);
                conext.setAttribute("users", userList);

            }
            System.out.println("user added");
            return true;
        }
    }

    @Override
    public User getUserByLogin(String login) {
        List<User> users = getAllUsers();
        for (User it : users) {
            System.out.println(it);
            if (it.getLogin().equals(login)) {
                return it;
            }
        }
        return null;
    }

    @Override
    public void updateScore(User user) {
        List<User> users = getAllUsers();
        for (User it : users) {
            if (it.getLogin().equals(user.getLogin())) {
                it.setBestScore(user.getBestScore());
                break;
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) conext.getAttribute("users");
    }
}
