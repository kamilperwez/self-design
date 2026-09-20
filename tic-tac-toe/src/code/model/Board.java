package code.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int dimensions;

    public Board(int dimensions) {
        this.board = new ArrayList<>();
        this.dimensions = dimensions;
        for(int i=0;i<dimensions;i++){
            board.add(new ArrayList<>());
            for(int j=0;j<dimensions;j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }
    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }



}
