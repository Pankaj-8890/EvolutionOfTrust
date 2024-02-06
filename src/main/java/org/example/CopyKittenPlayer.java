package org.example;

import java.awt.*;

public class CopyKittenPlayer extends Player {

    private boolean gainedLastRound = true;

    @Override
    public Action takeAction(){
        Action action = Action.CHEAT;
        if(gainedLastRound)
            action = Action.COOPERATE;
        this.gainedLastRound = false;
        return action;
    }

    @Override
    public void gain() {
        this.gainedLastRound = true;
        super.gain();
    }
}
