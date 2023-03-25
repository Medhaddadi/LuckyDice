package com.dl.jeudesensah.web.Helpers;

import com.dl.jeudesensah.Beans.User;

import java.util.Hashtable;

public class Game {
    User user;
    int score;
    boolean gameover = false;
    Hashtable<Integer, Integer> desNumberValue = new Hashtable<Integer, Integer>();

    public Game(int score, boolean gameover, User user) {
        this.score = score;
        this.gameover = gameover;
        this.user = user;
    }

    public int generateRandomNumber() {
        int min = 1;
        int max = 6;
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        user.setBestScore(score);
        this.score = score;
    }

    public boolean isGameover() {
        return gameover;
    }

    public void setGameover(boolean gameover) {
        this.gameover = gameover;
    }

    public Hashtable<Integer, Integer> getDesNumberValue() {
        return desNumberValue;
    }

    public void setDesNumberValue(Hashtable<Integer, Integer> desNumberValue) {
        this.desNumberValue = desNumberValue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addDesNumberValue(int desNumber, int desValue) {
        if (desNumberValue.size() < 3) {
            if (desNumberValue.containsKey(desNumber)) {
                System.out.println("Des number already exist");
                setScore(-1);
                this.gameover = true;
            } else {
                desNumberValue.put(desNumber, desValue);
                if (desNumberValue.containsKey(2) && (desNumberValue.get(2) == 1 || desNumberValue.get(2) == 6)) {
                    setScore(0);
                    this.gameover = true;
                    System.out.println("Game over, des number 2 is 1 or 6");
                }
            }
            if (desNumberValue.size() == 3)
            {
                System.out.println("Game over,we have 3 des number");
                this.gameover = true;
                this.calculatescore();
            }
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "user=" + user +
                ", score=" + score +
                ", gameover=" + gameover +
                ", desNumberValue=" + desNumberValue +
                '}';
    }

    public void calculatescore() {
        if (desNumberValue.size() == 3) {
            if (desNumberValue.get(1) > desNumberValue.get(2) && desNumberValue.get(2) > desNumberValue.get(3)) {
                this.score = desNumberValue.get(1) * desNumberValue.get(2) * desNumberValue.get(3);
            }
            else if (desNumberValue.get(1) < desNumberValue.get(2) && desNumberValue.get(2) < desNumberValue.get(3)) {
                setScore(desNumberValue.get(1) + desNumberValue.get(2) + desNumberValue.get(3));
            }else{
                //for test purpose
                setScore(desNumberValue.get(1) + desNumberValue.get(2) + desNumberValue.get(3));
            }
            System.out.println("the new score  Score is " + this.score);
        }
    }
}