package org.example;

public class CooperatePlayer extends Player{
    @Override
    public Action takeAction(){
        return Action.COOPERATE;
    }
}
