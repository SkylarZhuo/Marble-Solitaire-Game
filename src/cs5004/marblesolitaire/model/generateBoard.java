package cs5004.marblesolitaire.model;

import com.sun.corba.se.impl.interceptors.PICurrent;

/**
 * A helper class to generate the Marble piece board
 */
public  class generateBoard {

    /**
     * A helper method to generate the marble piece board for different constructor
     * @param armThickness the arm thickness of the board
     * @param slotRow the row of the empty slot
     * @param slotCol the column of the empty slot
     * @return get and return a 2D Piece board based on the input field
     * @throws IllegalArgumentException throw an exception when arm thickness or sRow or sCol is invalid
     */
    public static Piece[][] createBoard(int armThickness , int slotRow, int slotCol) throws IllegalArgumentException {
        if(armThickness % 2 ==0 || armThickness < 0){
            throw new IllegalArgumentException("The arm thickness must be a positive odd number!");
        }
        int size = 2 * armThickness + 1;
        if(slotRow < 0 || slotCol < 0 || slotRow > size || slotCol > size){
            throw new IllegalArgumentException("The row or column is invalid!");
        }
        Piece[][] board = new Piece[size][size];

        //Set all the cell to INVALID initially
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                board[i][j] = Piece.INVALID;
            }
        }
        //Set the marble piece
        int wing = (int) (0.5 * armThickness + 0.5);
        for(int i = wing; i < wing+armThickness; i++){
            for(int j = 0; j < size; j++){
                    board[i][j] = Piece.MARBLE;
            }
        }

        for(int j = wing ; j < wing+armThickness ; j++){
            for(int i = 0 ; i < size ; i++){
                    board[i][j] = Piece.MARBLE;
            }
        }
        //Set the empty piece
        if(board[slotRow][slotCol] != Piece.INVALID){
            board[slotRow][slotCol] = Piece.EMPTY;
        }

        return board;
    }

}
