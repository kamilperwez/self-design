package code.controller;

import code.model.*;

import java.util.List;
import java.util.Scanner;

public class GameController {
    public Game createGame(int dimension, List<Player> players){
        return Game.builder()
                .setDimension(dimension)
                .setPlayers(players)
                .build();
    }
    public void displayGame(Game game){

    }
    public Game updateGameStatus(Game game, GameStatus gameStatus){
        game.setGameStatus(gameStatus);
        return game;
    }
    public GameStatus getStatus(Game game){
        return game.getGameStatus();
    }
    public Move executeMove(Game game, Player player){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the row for the cell");
        int row= sc.nextInt();
        System.out.println("Please enter the col for the cell");
        int col= sc.nextInt();
        //VALIDATE ROW CELL
        Cell playedMoveCell=game.getBoard().getMatrix().get(row).get(col);
        playedMoveCell.setCellState(CellState.FILLED);
        playedMoveCell.setPlayer(player);
        return new Move(player,playedMoveCell);
    }
    public Player checkWinner(Game game, Move move){
        return null;
    }
    public Board undoMove(Game game, Move move){
        return null;
    }
    public  void replayGame(Game game){

    }
}
