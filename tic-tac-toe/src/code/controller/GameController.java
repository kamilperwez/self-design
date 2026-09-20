package code.controller;

import code.model.Board;
import code.model.Game;
import code.model.Move;
import code.model.Player;
import code.model.GameStatus;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players){
        return Game.builder()
                .setDimension(dimension)
                .setPlayers(players)
                .build();
    }
    public void displayGame(Game game){

    }
    public GameStatus getStatus(Game game){
        return null;
    }
    public Move executeMove(Game game, Move move){
        return null;
    }
    public Player checkWinner(Game game){
        return null;
    }
    public Board undoMove(Game game, Move move){
        return null;
    }
    public  void replayGame(Game game){

    }
}
