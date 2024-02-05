package org.example;

public class CopyKittenPlayer extends Player {

    private boolean investLastRound = false;
    @Override
    public Action takeAction(){
        Action action = Action.COOPERATE;
        if(investLastRound){
            action = Action.CHEAT;
        }
        investLastRound = false;
        return action;
    }

    @Override
    public void invest(){
        this.investLastRound = true;
    }
}
