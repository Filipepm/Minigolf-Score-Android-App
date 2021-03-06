import android.graphics.Color;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import Player.java;

class Game implements Serializable{

public Game(){
    int maxPlayerID = 0;
    int gameID = getMaxGameID()+1;
    String gameName;
    ArrayList<Player> players = new ArrayList<Player>;
}

    public String getGameName(){
        return this.gameName;
    }

    public void setGameName(String name){
        this.gameName = name;
    }

    public void addPlayer(String playerName, Color playerColor){
        this.players.add(new Player(maxPlayerId++, playerName, playerColor));
    }

    public void removePlayer(int playerID){
        players.remove(players.indexOf(players.stream().filter(player -> playerID.equals(player.getPlayerID()))).findFirst().orElse(null));
    }

    public int getScore(int playerID, int holeID){
        return(players.stream().filter(player -> playerID.equals(player.getPlayerID())).getScore(holeID));
    }

    public void setScore(int playerID, int holeID, int score){
        players.stream().filter(player -> playerID.equals(player.getPlayerID())).setScore(holeID, score);
    }

    //TODO: implement saveGame()
    public void saveGame(){
        File file = new File(context.getFilesDir() + gameID.toString())//TODO: determine file extension
        //TODO: serialize to file
    }

    //TODO: implement loadGame()
    public Game loadGame(int gameID){
        return new Game;
    }

    private int getMaxGameID(){
        File directory = new File(context.getFilesDir());
        ArrayList<String> filenames = new ArrayList<String>(Arrays.asList(directory.list()));
        ArrayList<Integer> filenumbers = new Arraylist<Integer>;
        for(String filename : filenames){
            int filenumber = Integer.parseInt(filename); //TODO: regex out file extensions
            filenumbers.add(filenumber);
        return(Collections.max(filenumbers))
        }
    }
}