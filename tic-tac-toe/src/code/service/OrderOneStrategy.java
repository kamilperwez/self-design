package code.service;

import code.model.Board;
import code.model.Cell;
import code.model.Move;
import code.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneStrategy implements WinnerCheckStrategy {
    private int dimension;
    private List<HashMap<Character,Integer>> rowHashMapList=new ArrayList<>();
    private List<HashMap<Character,Integer>> colHashMapList=new ArrayList<>();
    private HashMap<Character,Integer> leftDiagonalHashMap=new HashMap<>();
    private HashMap<Character,Integer> rightDiagonalMap=new HashMap<>();
    private HashMap<Character,Integer> cornerHashMap=new HashMap<>();

    public OrderOneStrategy(int dimension) {
        this.dimension = dimension;
        for(int i=0;i<dimension;i++){
            rowHashMapList.add(new HashMap<>());
            colHashMapList.add(new HashMap<>());
        }
    }

    @Override
    public Player checkWinner(Board board, Move lastPlayedMove) {
        Player player=lastPlayedMove.getPlayer();
        Cell cell=lastPlayedMove.getCell();
        int row=cell.getRow();
        int col=cell.getCol();
        boolean check= (
                (checkRowsAndCols(rowHashMapList,player,row)) ||
                        (checkRowsAndCols(colHashMapList,player,col)) ||
                        (checkLeftDiagonal(row,col,leftDiagonalHashMap,player))||
                        (checkRightDiagonal(row,col,rightDiagonalMap,player)) ||
                        (checkCorners(row,col,cornerHashMap,player))
                );
        if(check){
            return player;
        }
        return null;
    }
    public boolean checkRowsAndCols(List<HashMap<Character,Integer>> listHashMap, Player player,int index){
        HashMap<Character,Integer>hm=listHashMap.get(index);
        hm.put(player.getSymbol(),hm.getOrDefault(player.getSymbol(),0)+1);
        if(hm.size()>=2)return false;
        if(hm.get(player.getSymbol())==dimension)return true;
        return false;
    }
    public boolean checkLeftDiagonal(int row,int col, HashMap<Character,Integer> hm, Player player){
        if(row==col){
            hm.put(player.getSymbol(),hm.getOrDefault(player.getSymbol(),0)+1);
            if(hm.get(player.getSymbol())==dimension)return true;
        }
        return false;
    }
    public boolean checkRightDiagonal(int row,int col, HashMap<Character,Integer> hm, Player player){
        if(row+col==dimension-1){
            hm.put(player.getSymbol(),hm.getOrDefault(player.getSymbol(),0)+1);
            if(hm.get(player.getSymbol())==dimension)return true;
        }
        return false;
    }
    public boolean checkCorners(int row,int col,HashMap<Character,Integer> hm, Player player){
        if((row==0 &&col==0) || (row==0 &&col==dimension-1) || (row==dimension-1 &&col==0) || (row==dimension-1 && col==dimension-1)){
            hm.put(player.getSymbol(),hm.getOrDefault(player.getSymbol(),0)+1);
            if(hm.get(player.getSymbol())==4)return true;
        }
        return false;
    }
}
