package code.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> matrix;
    private int dimensions;

    public Board(int dimensions) {
        this.matrix = new ArrayList<>();
        this.dimensions = dimensions;
        for(int i=0;i<dimensions;i++){
            matrix.add(new ArrayList<>());
            for(int j=0;j<dimensions;j++){
                matrix.get(i).add(new Cell(i,j));
            }
        }
    }

    public List<List<Cell>> getMatrix() {
        return matrix;
    }
    public void setMatrix(List<List<Cell>> matrix) {
        this.matrix = matrix;
    }

    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }



}
