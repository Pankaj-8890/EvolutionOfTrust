package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Tournament {

    private List<Player> playerList;

    private TrustMachine trustMachine;

    public Tournament(){
        playerList = new ArrayList<>();
    }

    public void add(Player player){
        playerList.add(player);
    }

    public void startTournament(int rounds) {

        for(int r=1;r<=rounds;r++){

            if(checkAllPlayerSame()) return;

            for(int i=0;i<playerList.size();i++){
                for(int j=i+1;j<playerList.size();j++){
                    trustMachine = new TrustMachine(playerList.get(i),playerList.get(j));
                    trustMachine.TrustTransaction(1);
                }
            }
            eliminateWorst5Players();
            cloneTop5Players();
        }
    }

    public void cloneTop5Players(){
        playerList.sort(Comparator.comparing(Player::getScore).reversed());
        for(int i=0;i<5;i++){
            playerList.add(playerList.get(i).clone());
        }

    }

    public void eliminateWorst5Players(){
        playerList.sort(Comparator.comparing(Player::getScore));
        for(int i=0;i< playerList.size()-5;i++){
            playerList.remove(playerList.get(i));
        }
    }
    public Boolean checkAllPlayerSame(){

        Player player = playerList.getFirst();
        for(int i=1;i< playerList.size();i++){
            if(player.getClass() != playerList.get(i).getClass())return false;
        }
        return true;
    }
}
