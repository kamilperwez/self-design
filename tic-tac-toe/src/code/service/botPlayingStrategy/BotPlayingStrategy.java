package code.service.botPlayingStrategy;

import code.model.Board;
import code.model.Move;
import code.model.Player;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Player player);
}
