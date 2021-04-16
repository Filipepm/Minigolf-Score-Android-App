package com.example.androidapp;

import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class Game implements Serializable{

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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void removePlayer(int playerID){
        players.remove(players.indexOf(players.stream().filter(player -> (Integer)playerID.equals((Integer)player.getPlayerID()))).findFirst().orElse(null));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int getScore(int playerID, int holeID) {
        return(players.stream().filter(player -> playerID.equals(player.getPlayerID())).getScore(holeID));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setScore(int playerID, int holeID, int score){
        players.stream().filter(player -> playerID.equals(player.getPlayerID())).setScore(holeID, score);
    }

    //TODO: implement saveGame()
    public void saveGame(){
        File file = new File(context.getFilesDir() + gameID.toString());//TODO: determine file extension
        //TODO: serialize to file
    }

    //TODO: implement loadGame()
    public Game loadGame(int gameID){
        return new Game();
    }

    private int getMaxGameID(){
        File directory = new File(context.getFilesDir());
        ArrayList<String> filenames = new ArrayList<String>(Arrays.asList(directory.list()));
        ArrayList<Integer> filenumbers = new ArrayList<Integer>();
        for(String filename : filenames){
            int filenumber = Integer.parseInt(filename); //TODO: regex out file extensions
            filenumbers.add(filenumber);
        return(Collections.max(filenumbers));
        }
    }
}