package com.golfstonks.androidapp;

import android.graphics.Color;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Game{

    int maxPlayerID;
    int gameID;
    String gameName;
    ArrayList<Player> players;

    public Game() {
        maxPlayerID = 0;
        gameID = getMaxGameID()+1;
        players = new ArrayList<Player>();
    }

    public String getGameName(){
        return this.gameName;
    }

    public void setGameName(String name){
        this.gameName = name;
    }

    public void addPlayer(String playerName, Color playerColor){
        this.players.add(new Player(maxPlayerID++, playerName, playerColor));
    }

    public void setMaxPlayerID(int playerID) {
        this.maxPlayerID = playerID;
    }

    /*
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void removePlayer(int playerID){
        players.remove(players.indexOf(players.stream().filter(player -> playerID.equals(player.getPlayerID()))).findFirst().orElse(null));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int getScore(int playerID, int holeID) {
        return(players.stream().filter(player -> playerID.equals(player.getPlayerID())).getScore(holeID));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setScore(int playerID, int holeID, int score){
        players.stream().filter(player -> playerID.equals(player.getPlayerID())).setScore(holeID, score);
    }
    */

    public void saveGame() throws IOException {
        FileOutputStream fileStream = new FileOutputStream(String.valueOf(this.gameID) + ".ser");
        ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
        objectStream.writeObject(this);
        objectStream.close();
    }

    public Game loadGame(int gameID) throws IOException, ClassNotFoundException {
        FileInputStream fileStream = new FileInputStream(String.valueOf(gameID) + ".ser");
        ObjectInputStream inputStream = new ObjectInputStream(fileStream);
        Game loadedGame = (Game) inputStream.readObject();
        inputStream.close();
        return loadedGame;
    }
    
    private int getMaxGameID() {
        File directory = new File("./");
        ArrayList<String> filenames = new ArrayList<String>(Arrays.asList(directory.list()));
        ArrayList<Integer> filenumbers = new ArrayList<Integer>();
        for(String filename : filenames){
            int filenumber = Integer.parseInt(filename); //TODO: regex out file extensions
            filenumbers.add(filenumber);
        }
        return(Collections.max(filenumbers));
    }
}