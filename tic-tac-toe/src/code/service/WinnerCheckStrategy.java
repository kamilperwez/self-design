package code.service;

import code.model.Board;
import code.model.Move;
import code.model.Player;

public interface WinnerCheckStrategy {
    Player checkWinner(Board board, Move lastPlayedMove);

}
