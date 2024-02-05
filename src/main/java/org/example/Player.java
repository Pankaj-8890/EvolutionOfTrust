package org.example;

import java.util.Random;

public class Player{
    public Action takeAction(){
        Random random = new Random();
        return random.nextInt(2) == 0 ? Action.CHEAT : Action.COOPERATE;
    }

    public void gain(){

    }

    public void invest(){

    }
}
