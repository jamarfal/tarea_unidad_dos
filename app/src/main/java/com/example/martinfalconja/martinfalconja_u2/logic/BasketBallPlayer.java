package com.example.martinfalconja.martinfalconja_u2.logic;

/**
 * Created by jamarfal on 26/9/16.
 */

public class BasketBallPlayer implements ThrowBehavior {
    private Score score;
    private final int THREEPOINTS = 3;
    private final int TWOPOINTS = 2;
    private final int ONEPOINT = 1;

    public BasketBallPlayer(Score score) {
        this.score = score;
    }

    public int getPoints() {
        return this.score.getScore();
    }


    public void resetPoints() {
        this.score.resetScore();
    }

    @Override
    public void throwThreePoints() {
        score.addPoints(THREEPOINTS);
    }

    @Override
    public void throwTwoPoints() {
        score.addPoints(TWOPOINTS);
    }

    @Override
    public void throwFreeThrow() {
        score.addPoints(ONEPOINT);
    }
}
