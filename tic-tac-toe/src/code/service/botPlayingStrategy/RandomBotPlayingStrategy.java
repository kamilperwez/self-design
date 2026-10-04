package code.service.botPlayingStrategy;

import code.exceptions.DrawGameException;
import code.model.*;

import java.util.List;

public class RandomBotPlayingStrategy implements  BotPlayingStrategy{

    @Override
    public Move makeMove(Board board, Player player) {
        List<List<Cell>> matrix=board.getMatrix();
        for(int i=0;i< matrix.size();i++){
            for(int j=0;j< matrix.size();j++){
                if(matrix.get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    matrix.get(i).get(j).setCellState(CellState.FILLED);
                    matrix.get(i).get(j).setPlayer(player);
                    return new Move(player,matrix.get(i).get(j));
                }
            }
        }
        throw new DrawGameException("No More EMPTY CELLS AVAILABLE! ");
    }
}
