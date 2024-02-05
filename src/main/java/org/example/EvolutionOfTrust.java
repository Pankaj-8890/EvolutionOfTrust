package org.example;

import javafx.util.Pair;

import static org.example.Behaviour.CHEAT;
import static org.example.Behaviour.COOPERATE;

public class EvolutionOfTrust {

    private int round;

    public EvolutionOfTrust(){

    }


    public int startGame(Behaviour b1,Behaviour b2){

        if(b1 == COOPERATE && b2 == COOPERATE){
            return 2;
        } else if (b1 == COOPERATE && b2 == CHEAT) {
            return 1;
        } else if (b1 == CHEAT && b2 == COOPERATE) {
            return 3;
        }else{
            return 0;
        }

    }
}