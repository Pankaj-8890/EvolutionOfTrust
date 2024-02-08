package org.example;

import java.util.Objects;
import java.util.Random;

public class Player{

    private int score = 0;
    public Action takeAction(){
        Random random = new Random();
        return random.nextInt(2) == 0 ? Action.CHEAT : Action.COOPERATE;
    }

    private void addScore(int score) {
        this.score += score;
    }
    public void gain(){
        addScore(3);
    }

    public void invest(){
        addScore(-1);
    }

    public int getScore(){
        return this.score;
    }

    public Player clone(){
        return new Player();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return score == player.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
