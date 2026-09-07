package code;

import java.util.List;

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
        

    }
    public  static class Builder{
        private Board board;
        List<Player> players;
        private Player winner;
        private GameStatus gameStatus;
        private List<Move> moves;
        private Player currentPlayer;
        private List<Board> oldBoardStates;

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
    }

}
