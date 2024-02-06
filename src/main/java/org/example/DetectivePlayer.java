package org.example;

public class DetectivePlayer extends CopyCatPlayer{

    private int rounds = 0;
    private boolean isCopyCat = false;
    private boolean gainLastRound = false;
    private boolean investedLastRound = false;


    @Override
    public Action takeAction(){


        this.rounds++;
        Action action = Action.CHEAT;
        if(rounds == 1){

            action = Action.COOPERATE;
        }else if (rounds == 2) {
            action =  Action.CHEAT;
        }
        if (investedLastRound) {
            this.isCopyCat = true;
        }
        if(isCopyCat){
            if (gainLastRound) {
                action = Action.COOPERATE;
            }
            gainLastRound = false;
        }
        return action;
    }
    @Override
    public void gain(){
        this.gainLastRound = true;
        if (this.investedLastRound) {
            this.investedLastRound = false;
        }
        super.gain();
    }
    @Override
    public void invest(){
        this.investedLastRound = true;
        super.invest();
    }

}
