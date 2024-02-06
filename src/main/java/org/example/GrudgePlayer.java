package org.example;

public class GrudgePlayer extends Player{

    private boolean lastInvestRound = false;
    private int cheatCount = 0;


    @Override
    public  Action takeAction(){
        if(cheatCount==1){
            lastInvestRound = true;
        }
        Action action = Action.COOPERATE;
        if(lastInvestRound)
            action = Action.CHEAT;

        return action;
    }

    @Override
    public void invest() {
        cheatCount++;
        super.invest();
    }

    @Override
    public void gain() {
        cheatCount--;
        super.gain();
    }
}
