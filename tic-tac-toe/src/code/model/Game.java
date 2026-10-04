package code.model;

import code.exceptions.DuplicateSymbolException;
import code.exceptions.InvalidBoardDimensionException;
import code.exceptions.InvalidBotOccurence;
import code.exceptions.InvalidNumberOfPlayersException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private Board board;
    List<Player> players;
    private Player winner;
    private GameStatus gameStatus;
    private List<Move> moves;
    private Player currentPlayer;
    private List<Board> oldBoardStates;
    private Game(Board board, List<Player> players){
        this.board=board;
        this.players=players;
        this.gameStatus=GameStatus.YET_TO_START;
        this.moves=new ArrayList<>();
        this.oldBoardStates=new ArrayList<>();

    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List<Board> getOldBoardStates() {
        return oldBoardStates;
    }

    public void setOldBoardStates(List<Board> oldBoardStates) {
        this.oldBoardStates = oldBoardStates;
    }

    public static Builder builder(){
        Builder builder=new Builder();
        return builder;
    }
    public  static class Builder{
        private Board board;
        List<Player> players;
        private Player winner;
        private GameStatus gameStatus;
        private List<Move> moves;
        private Player currentPlayer;
        private List<Board> oldBoardStates;
        private int dimension;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinner(Player winner) {
            this.winner = winner;
            return this;
        }

        public Builder setGameStatus(GameStatus gameStatus) {
            this.gameStatus = gameStatus;
            return this;
        }

        public Builder setMoves(List<Move> moves) {
            this.moves = moves;
            return this;
        }

        public Builder setCurrentPlayer(Player currentPlayer) {
            this.currentPlayer = currentPlayer;
            return this;
        }

        public Builder setOldBoardStates(List<Board> oldBoardStates) {
            this.oldBoardStates = oldBoardStates;
            return this;
        }
        private void validateNumberOfPlayers(Board board,List<Player> players){
            if(players.size()!=board.getDimensions()-1){
                throw new InvalidNumberOfPlayersException("Players are not equal to N-1");
            }
        }
        private void validateUniqueSymbols(List<Player> players){
            Set<Character> uniqueSymbols=new HashSet<>();
            for(Player player :players){
                if(uniqueSymbols.contains(player.getSymbol())){
                    throw new DuplicateSymbolException("Duplicate Player Symbol Detected : "+player.getSymbol());
                }
                uniqueSymbols.add(player.getSymbol());
            }
        }
        private void validateBoardDimension(Board board){
            if(board.getDimensions()<3 || board.getDimensions()>10){
                throw new InvalidBoardDimensionException("Board Dimensions must be between 3 amd 10");
            }
        }
        private void validateBotOccurence(List<Player> players){
            int countBot=0;
            for(Player player:players){
                if(player.getPlayerType()==PlayerType.BOT){
                    countBot++;
                }
                if(countBot >=2)throw new InvalidBotOccurence("We can have only 1 Bot in the game.");
            }
        }
        public void validate(){
            validateBoardDimension(this.board);
            validateNumberOfPlayers(this.board,this.players);
            validateBotOccurence(this.players);
            validateUniqueSymbols(this.players);
        }
        public  Game build(){
            this.board=new Board(dimension);
            validate();
            return new Game(board,players);
        }
    }

}
