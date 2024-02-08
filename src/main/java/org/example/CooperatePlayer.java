package org.example;

public class CooperatePlayer extends Player{
    @Override
    public Action takeAction(){
        return Action.COOPERATE;
    }

    @Override
    public Player clone() {
        return new CooperatePlayer();
    }
}
