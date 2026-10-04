package code.controller;

import code.model.*;
import code.service.OrderOneStrategy;
import code.service.WinnerCheckStrategy;
import code.service.botPlayingStrategy.BotPlayingStrategy;
import code.service.botPlayingStrategy.RandomBotPlayingStrategy;

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
        System.out.println("TIC-TAC-TOE BOARD");
        List<List<Cell>> matrix=game.getBoard().getMatrix();
        for(List<Cell> row : matrix){
            for(Cell cell : row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    System.out.print("| |");
                }
                else{
                    System.out.print("|"+cell.getPlayer().getSymbol()+"|");
                }
            }
            System.out.println();
        }

    }
    public Game updateGameStatus(Game game, GameStatus gameStatus){
        game.setGameStatus(gameStatus);
        return game;
    }
    public GameStatus getStatus(Game game){
        return game.getGameStatus();
    }
    public Move executeMove(Game game, Player player){
        Scanner sc = new Scanner(System.in);
        if(player.getPlayerType().equals(PlayerType.HUMAN)) {
            while(true) {

                System.out.println("Please enter the row for the cell");
                int row = sc.nextInt();
                System.out.println("Please enter the col for the cell");
                int col = sc.nextInt();
                //VALIDATE ROW CELL
                if(row<0 || row>=game.getBoard().getDimensions() ||
                   col<0 || col>=game.getBoard().getDimensions() ){
                    System.out.println("Indexes out of Bounds! Please enter again -> ");
                    continue;
                }
                if(game.getBoard().getMatrix().get(row).get(col).getCellState().equals(CellState.FILLED)){
                    System.out.println(" Cell is  Already Filled. Please select a different cell ");
                    continue;
                }
                Cell playedMoveCell = game.getBoard().getMatrix().get(row).get(col);
                playedMoveCell.setCellState(CellState.FILLED);
                playedMoveCell.setPlayer(player);
                game.getMoves().add(new Move(player,playedMoveCell));
                return new Move(player, playedMoveCell);
            }
        }
        else{
            //TODO:Implement factory for Bot Strategies
            System.out.println("Bot is making a move : ");
            BotPlayingStrategy strategy=new RandomBotPlayingStrategy();
            Move botMove= strategy.makeMove(game.getBoard(),player);
            game.getMoves().add(botMove);
            return botMove;
        }
    }
    public Player checkWinner(Game game, Move move){

        return game.getWinnerCheckStrategy().checkWinner(game.getBoard(),move);
    }
    public Board undoMove(Game game, Move move){
        return null;
    }
    public  void replayGame(Game game){
        List<Move> moves = game.getMoves();

        if (moves.isEmpty()) {
            System.out.println("No moves to replay!");
            return;
        }

        // Clear the current board
        for (List<Cell> row : game.getBoard().getMatrix()) {
            for (Cell cell : row) {
                cell.setCellState(CellState.EMPTY);
                cell.setPlayer(null);
            }
        }

        System.out.println("REPLAYING GAME...");

        // Replay every move
        for (Move move : moves) {

            Cell cell = move.getCell();
            Player player = move.getPlayer();

            // Apply move
            cell.setCellState(CellState.FILLED);
            cell.setPlayer(player);

            // Display board after every move
            displayGame(game);

            System.out.println(
                    player.getSymbol() +
                            " played at (" +
                            cell.getRow() + ", " +
                            cell.getCol() + ")"
            );

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("Replay finished!");

    }
}
