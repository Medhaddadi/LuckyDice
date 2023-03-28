package com.dl.jeudesensah.database.mysqlDb;

import com.dl.jeudesensah.Beans.User;
import com.dl.jeudesensah.database.userDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userDaoMysqlImpl implements userDao {

    private final DaoFactory daoFactory;
    public userDaoMysqlImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean insertUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        try{
            connection = daoFactory.getConnection();
            try {
                User user1 = getUserByLogin(user.getLogin());
                if (user1 != null) {
                    return false;
                }
                preparedStatement = connection.prepareStatement("insert into user (nom,prenom,login,password,bestScore) values (?,?,?,?,?)");
                preparedStatement.setString(1, user.getNom());
                preparedStatement.setString(2, user.getPrenom());
                preparedStatement.setString(3, user.getLogin());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setInt(5, user.getBestScore());
                int rowIsert = preparedStatement.executeUpdate();
                return rowIsert != 0;

            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUserByLogin(String login) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        User user=null;
        try {
            connection = daoFactory.getConnection();
            try {
                preparedStatement = connection.prepareStatement("select * from user where login=?");
                preparedStatement.setString(1, login);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    user = getUserFromResultSet(resultSet);
                }
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void updateScore(User user) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection = daoFactory.getConnection();
            try {
                User user1 = getUserByLogin(user.getLogin());
                System.out.println("last score : " + user1.getBestScore() + " new score : " + user.getBestScore() + "");
                if (user1.getBestScore() > user.getBestScore()) {
                    return;
                } else {
                    user.setBestScore(user1.getBestScore());
                }
                preparedStatement = connection.prepareStatement("update user set bestScore=? where login=?");
                preparedStatement.setInt(1, user.getBestScore());
                preparedStatement.setString(2, user.getLogin());
                preparedStatement.executeUpdate();
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        Connection connection=null;
        Statement st=null;
        ResultSet resultSet=null;
        try {
            connection = daoFactory.getConnection();
            try {
                st = connection.createStatement();
                resultSet = st.executeQuery("select * from user order by bestScore desc");
                List<User> users = new ArrayList<>();
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setNom(resultSet.getString("nom"));
                    user.setPrenom(resultSet.getString("prenom"));
                    user.setLogin(resultSet.getString("login"));
                    user.setPassword(resultSet.getString("password"));
                    user.setBestScore(resultSet.getInt("bestScore"));
                    users.add(user);

                }
                return users;
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user=new User();
        user.setId(resultSet.getInt("id"));
        user.setNom(resultSet.getString("nom"));
        user.setPrenom(resultSet.getString("prenom"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setBestScore(resultSet.getInt("bestScore"));
        return user;
    }
}
