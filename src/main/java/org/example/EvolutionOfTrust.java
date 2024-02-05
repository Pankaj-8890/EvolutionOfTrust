package org.example;

import javafx.util.Pair;

import java.util.Random;

import static java.lang.Math.random;
import static org.example.Behaviour.CHEAT;
import static org.example.Behaviour.COOPERATE;

public class EvolutionOfTrust {

    private int round;

    private Player playerA;

    private Player playerB;

    private Behaviour Choice;

    public EvolutionOfTrust(Player playerA,Player playerB,int round){
        this.round = round;
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public Behaviour chooseBehaviour(){
        Random random = new Random();
        int randomNumber = random.nextInt(2);

        if (randomNumber == 0) {
            return Behaviour.COOPERATE;
        } else {
            return Behaviour.CHEAT;
        }
    }

    public int startGame(Player p1,Player p2){


        while(round > 0){
            Behaviour playerA = chooseBehaviour();
            Behaviour playerB = chooseBehaviour();
            if(playerA == COOPERATE && playerB == COOPERATE){
                return 2;
            } else if (playerA == COOPERATE && playerB == CHEAT) {
                return 1;
            } else if (playerA == CHEAT && playerB == COOPERATE) {
                return 3;
            }else{
                return 0;
            }

        }


    }
}