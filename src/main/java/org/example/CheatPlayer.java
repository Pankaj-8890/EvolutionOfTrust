package org.example;

public class CheatPlayer extends Player{

    @Override
    public Action takeAction(){
        return Action.CHEAT;
    }
}
