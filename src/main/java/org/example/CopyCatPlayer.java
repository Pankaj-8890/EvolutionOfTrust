package org.example;

public class CopyCatPlayer extends Player{

    private boolean gainLastRound = false;

    @Override
    public Action takeAction(){
        Action action = Action.CHEAT;
        if(gainLastRound){
            action = Action.COOPERATE;
        }
        gainLastRound = false;
        return action;
    }

    @Override
    public Player clone() {
        return new CopyCatPlayer();
    }

    @Override
    public void gain(){
        this.gainLastRound = true;
        super.gain();
    }

}
