package com.example.codeclan.rockpaperscissors;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private ArrayList<String> androidOptions;
    private int userTotal, androidTotal;

    public Game(){

        this.androidOptions = new ArrayList<>();
        androidOptions.add(GameOption.PAPER.getName());
        androidOptions.add(GameOption.ROCK.getName());
        androidOptions.add(GameOption.SCISSORS.getName());
        userTotal = 0;
        androidTotal = 0;
    }

    public String generateRandomSelection(){
        Collections.shuffle(androidOptions);
        return androidOptions.get(0);
    }

    public String getWinner(String option){
        String android = generateRandomSelection();
        String player1 = option;
        return returnWinner(player1, android);
    }

    public String returnWinner(String option1, String option2) {
        if((option1 == "Rock" && option2 == "Scissors") ||
                (option1 == "Scissors" && option2 == "Paper") ||
                (option1 == "Paper" && option2 == "Rock")) {
            userTotal += 1;
            return "Player won with: " + option1 + " android selected: " + option2;
        } else if ((option2 == "Rock" && option1 == "Scissors") ||
                (option2 == "Scissors" && option1 == "Paper") ||
                (option2 == "Paper" && option1 == "Rock")){
            androidTotal += 1;
            return "Android won with: " + option2 + " player selected: " + option1;
        } else {
            return "its a draw";
        }
    }

    public String getUserTotal(){
        return String.format("Player has Won %d time(s)", this.userTotal);
    }

    public String getAndroidTotal(){
        return String.format("Android has Won %d time(s)", this.androidTotal);
    }

    public String getAllTotal(){
        return getUserTotal() + " " + getAndroidTotal();
    }


}
