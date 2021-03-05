import android.graphics.Color;
import java.util.ArrayList;

import Player.java;

public class Game{
    int gameID;
    int maxPlayerID = 0;
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
}

//TODO: implement loadGame()
public Game loadGame(){
    return null;
}