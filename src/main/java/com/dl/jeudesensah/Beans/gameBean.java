package com.dl.jeudesensah.Beans;

import java.sql.Date;

public class gameBean {
    int id;
    int userId;
    int score;
   Date date;

    public gameBean(int id, int userId, int score, Date date) {
        this.id = id;
        this.userId = userId;
        this.score = score;
        this.date = date;
    }

    public gameBean() {

    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "game{" +
                "id=" + id +
                ", userId=" + userId +
                ", score=" + score +
                ", date='" + date + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
