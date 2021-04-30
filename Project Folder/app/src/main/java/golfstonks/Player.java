package golfstonks;

import android.graphics.Color;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable{

    int playerID;
    String playerName;
    Color playerColor;
    ArrayList<Integer> scores;

    public Player() {
        scores = new ArrayList<Integer>();
    }

    public Player(int playerID, String playerName, Color playerColor) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.playerColor = playerColor;
    }

    public int getPlayerID(){
        return this.playerID;
    }

    public void setPlayerID(int ID){
        this.playerID = ID;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public void setPlayerName(String name){
        this.playerName = name;
    }

    public Color getColor(){
        return this.playerColor;
    }

    public void setColor(Color color){
        this.playerColor = color;
    }

    public int getScore(int holeID){
        return this.scores.get(holeID-1);
    }

    public void setScore(int holeID, int score){
        if(scores.size() <= holeID)
            scores.ensureCapacity(holeID);
        this.scores.set(holeID-1, score);
    }
}