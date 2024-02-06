package org.example;

import java.awt.*;

public class CopyKittenPlayer extends Player {

    private boolean gainedLastRound = false;

    private boolean investLastRound = false;

    @Override
    public Action takeAction(){
        Action action = Action.COOPERATE;
        if(!gainedLastRound && investLastRound)
            action = Action.CHEAT;
        this.gainedLastRound = false;
        return action;
    }

    @Override
    public void gain() {
        this.gainedLastRound = true;
        super.gain();
    }

    @Override
    public void invest() {
        this.investLastRound = true;
        super.invest();
    }
}
