package com.example.reza.myapplication;

/**
 * Created by reza on 2/14/18.
 */

public class Game {
    public String p1name;
    public String p2name;
    public int p1winnings;
    public int p2winnings;
    boolean isFinished;

    public Game(String p1name, String p2name) {
        this.p1name = p1name;
        this.p2name = p2name;
        p1winnings = 0;
        p2winnings = 0;
        isFinished = false;
    }

    public void p1win(){
        p1winnings++;
    }

    public void p2win(){
        p2winnings++;
    }

    public int match(String p1choice, String p2choice){
        /*returns:
        1 if player 1 win
        2 if player 2 win
        0 if tie
         */
        if(p1choice.equals("Rock")){
            if(p2choice.equals("Rock")){
                return 0;
            }
            else if(p2choice.equals("Paper")){
                p2winnings++;
                return 2;
            }
            else{
                p1winnings++;
                return 1;
            }
        }
        else if(p1choice.equals("Paper")){
            if(p2choice.equals("Rock")){
                p1winnings++;
                return 1;
            }
            else if(p2choice.equals("Paper")){
                return 0;
            }
            else{
                p2winnings++;
                return 2;
            }
        }
        else{
            if(p2choice.equals("Rock")){
                p2winnings++;
                return 2;
            }
            else if(p2choice.equals("Paper")){
                p1winnings++;
                return 1;
            }
            else{
                return 0;
            }
        }
    }

    public int overallWinner(){
        if(this.p1winnings > this.p2winnings){
            return 1;
        }
        else if(this.p1winnings < this.p2winnings){
            return 2;
        }
        else {
            return 0;
        }
    }
}
