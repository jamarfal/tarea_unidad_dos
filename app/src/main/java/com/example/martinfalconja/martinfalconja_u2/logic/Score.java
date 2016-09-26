package com.example.martinfalconja.martinfalconja_u2.logic;

/**
 * Created by jamarfal on 26/9/16.
 */

public class Score {
    private int score;

    public Score() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void addPoints(int points) {
        score += points;
    }

    public void resetScore() {
        score = 0;
    }

}
