package org.example;

public class DetectivePlayer extends Player{

    private int rounds = 0;
    private boolean isCopyCat = false;
    private boolean gainLastRound = false;

    private boolean investedLastRound = false;


    @Override
    public Action takeAction(){

        this.rounds++;
        Action action = Action.CHEAT;
        if(rounds == 1){
            if(gainLastRound){
                isCopyCat = true;
            }
            action = Action.COOPERATE;
        } else if (rounds == 2) {
            if(gainLastRound){
                isCopyCat = true;
            }
            action =  Action.CHEAT;
        }else if (investedLastRound && !isCopyCat) {
            this.isCopyCat = true;
        }else{
            if(isCopyCat){
                if (gainLastRound) {
                    action = Action.COOPERATE;
                }
                gainLastRound = false;
            }
        }

        return action;
    }
    @Override
    public void gain(){
        this.gainLastRound = true;
        super.gain();
    }
    @Override
    public void invest(){
        this.investedLastRound = true;
        super.invest();
    }

}
