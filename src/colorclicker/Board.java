package colorclicker;

import java.util.ArrayList;

public class Board {
    
    private ArrayList<ArrayList<Field>> board;
    private final int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        board = new ArrayList<>();
        for(int i = 0; i < this.boardSize; ++i){
            ArrayList<Field> row = new ArrayList<>(); // sor
            for(int j = 0; j < this.boardSize; ++j){
                row.add(new Field());
            }
            board.add(row); // sor oszlopos indexelés 
        }
    }

    public int getBoardSize() {
        return boardSize;
    }
    
    public boolean isOver(){
        for(int i = 0; i < boardSize; ++i){
            for(int j = 0; j < boardSize; ++j ){
                if( get(i,j).getColor() == null ){
                    return false;
                }
            }
        }
        return true;
    }
    
    public Field get(int i,int j){
        return board.get(i).get(j);
    }
    
    
    
    
    
    
}
