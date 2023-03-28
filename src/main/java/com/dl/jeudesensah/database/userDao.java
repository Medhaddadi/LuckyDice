package com.dl.jeudesensah.database;

import com.dl.jeudesensah.Beans.User;

import java.util.List;

public interface userDao {
    public boolean insertUser(User user);
    public User getUserByLogin(String login);

    public void updateScore(User user);

    public List<User> getAllUsers();

}
