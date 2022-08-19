package cs5004.marblesolitaire.model;

/**
 * A class that implement the MarbleSolitaireModel class that represent the
 * model of Marble Solitaire chess game
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {

    private int sRow;
    private int sCol;
    private int armThickness;
    protected Piece[][] board;
    protected int boardSize;

    /**
     * The first constructor of MarbleSolitaireModelImpl
     * It should take no parameters, and initialize the
     * game board as shown above (arm thickness 3 with the empty slot at the center).
     */
    public MarbleSolitaireModelImpl() {
        this.sRow = 3;
        this.sCol = 3;
        this.armThickness = 3;
        this.board = generateBoard.createBoard(armThickness, sRow, sCol);
    }


    /**
     * The second constructor of MarbleSolitaireModelImpl
     * It should initialize the game board so that the arm
     * thickness is 3 and the empty slot is at the position (sRow, sCol).
     *
     * @param sRow the row of the empty slot
     * @param sCol the column of the empty slot
     * @throws IllegalArgumentException throw an exception when sRow or sCol is invalid
     */
    public MarbleSolitaireModelImpl(int sRow, int sCol) throws IllegalArgumentException {
        this.boardSize = getBoardSize(3);
        if (!isValidSlot(boardSize, sRow, sCol)) {
            throw new IllegalArgumentException("Invalid empty cell position" + "(" + sRow + "," + sCol + ")");
        }
        this.armThickness = 3;
        this.sRow = sRow;
        this.sCol = sCol;
        this.board = generateBoard.createBoard(3, sRow, sCol);
        if (board[sRow][sCol] == Piece.INVALID) {
            throw new IllegalArgumentException("This is an invalid slot!");
        }
    }

    /**
     * The third constructor of MarbleSolitaireModelImpl
     * The third constructor should take the arm thickness
     * as its only parameter and initialize a game board with the empty slot at the center.
     *
     * @param armThickness the arm thickness of the board
     * @throws IllegalArgumentException throw an exception when arm thickness is invalid
     */
    //third constructor
    public MarbleSolitaireModelImpl(int armThickness) throws IllegalArgumentException {
        if (!isValidArm(armThickness)) {
            throw new IllegalArgumentException("This is an invalid arm thickness!");
        }
        this.boardSize = getBoardSize(armThickness);
        int centerSlot = (boardSize - 1) / 2;
        this.armThickness = armThickness;
        this.board = generateBoard.createBoard(armThickness, centerSlot, centerSlot);

    }

    /**
     * The fourth constructor of MarbleSolitaireModelImpl
     * It take the arm thickness, row and column of the empty slot in that order.
     *
     * @param armThickness the arm thickness of the board
     * @param sRow         the row of the empty slot
     * @param sCol         the column of the empty slot
     * @throws IllegalArgumentException throw an IllegalArgumentException if
     *                                  the arm thickness is not a positive odd number, or the empty cell position is invalid.
     */
    //forth constructor
    public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol) throws IllegalArgumentException {
        if (!isValidArm(armThickness)) {
            throw new IllegalArgumentException("This is an invalid arm thickness!");
        }
        this.armThickness = armThickness;
        this.sRow = sRow;
        this.sCol = sCol;
        this.boardSize = getBoardSize(armThickness);
        this.board = generateBoard.createBoard(armThickness, sRow, sCol);
        if (!isValidSlot(boardSize, sRow, sCol)) {
            throw new IllegalArgumentException("Invalid empty cell position" + "(" + sRow + "," + sCol + ")");
            //throw new IllegalArgumentException("Invalid empty cell position!");
        }
        if (board[sRow][sCol] == Piece.INVALID) {
            throw new IllegalArgumentException("This is an invalid slot!");
        }
    }

    /**
     * A helper method to get and return the size of the square of the board
     * @param armThickness the arm thickness of the board
     * @return the size of the square of the board
     * @throws IllegalArgumentException if the arm thickness is not a positive odd number or greater
     *                                   than 3, throw an exception
     */
    private int getBoardSize(int armThickness) throws IllegalArgumentException {
        if (!isValidArm(armThickness)) {
            throw new IllegalArgumentException("The arm thickness is invalid!");
        }
        return 2 * armThickness + 1;
    }


    @Override
    public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
        if (!isGameOver()) {
            int rowInBetween = (fromRow + toRow) / 2;
            int colInBetween = (fromCol + toCol) / 2;
            if (canMove(fromRow, fromCol, toRow, toCol)) {
                board[fromRow][fromCol] = Piece.EMPTY;
                board[toRow][toCol] = Piece.MARBLE;
                board[rowInBetween][colInBetween] = Piece.EMPTY;
            } else {
                throw new IllegalArgumentException("This is not a valid move!");
            }
        } else {
            throw new IllegalArgumentException("The game is over");
        }
    }

    /**
     * A helper method that decides whether the arm thickness is valid or not
     * @param armThickness the arm thickness of the board
     * @return a boolean represents whether the arm is valid or not
     */
    private boolean isValidArm(int armThickness) {
        if (armThickness < 3 || armThickness % 2 == 0) {
            return false;
        }
        return true;
    }

    /**
     * A helper method that decides whether the empty slot is valid or not
     * @param boardSize the size of the board
     * @param sRow the row of the empty slot
     * @param sCol the column of the empty slot
     * @return a boolean represent whether the empty slot is valid or not
     */
    private boolean isValidSlot(int boardSize, int sRow, int sCol) {
        if (sRow < 0 || sCol < 0 || sRow > boardSize || sCol > boardSize) {
            return false;
        }
        return true;
    }

    /**
     * A helper function to decide whether the move is valid or not
     * A move is valid if all these conditions are true:
     * (a) the “from” and “to” positions are valid
     * (b) there is a marble at the specified “from” position
     * (c) the “to” position is empty
     * (d) the “to” and “from” positions are exactly two positions away (horizontally or vertically)
     * @param fromRow the row of the from cell
     * @param fromCol the column of the from cell
     * @param toRow the row of the to cell
     * @param toCol the column of the to cell
     * @return a boolean that represent whether the movement is valid or not
     */
    //A move is valid if all these conditions are true:
    // (a) the “from” and “to” positions are valid
    // (b) there is a marble at the specified “from” position
    // (c) the “to” position is empty
    // (d) the “to” and “from” positions are exactly two positions away (horizontally or vertically)
    // (e) there is a marble in the slot between the “to” and “from” positions.
    private boolean canMove(int fromRow, int fromCol, int toRow, int toCol) {
        if (isOutOfBound(fromRow, fromCol) || isOutOfBound(toRow, toCol)) {
            return false;
        }
        if (board[fromRow][fromCol] == Piece.INVALID || board[toRow][toCol] == Piece.INVALID) {
            return false;
        }
        if (isValidFrom(fromRow, fromCol) && isValidTo(toRow, toCol) && isTwoPosAway(fromRow, fromCol, toRow, toCol)
                && isSlotBetween(fromRow, fromCol, toRow, toCol)) {
            return true;
        }
        return false;
    }

    /**
     * A helper method to check whether the "from" position is valid or not
     * @param fromRow the row of the from position
     * @param fromCol the column of the from position
     * @return a boolean that represents whether the from position is valid or not
     */
    private boolean isValidFrom(int fromRow, int fromCol) {
        if (isValidSlot(this.board.length, fromRow, fromRow)) {
            if (board[fromRow][fromCol] == Piece.MARBLE) {
                //System.out.println("valid from");
                return true;
            }
        }
        return false;
    }

    /**
     * A helper method to check whether the "to" position is valid or not
     * @param toRow the row of the to position
     * @param toCol the column of the to position
     * @return a boolean that represents whether the "to" position is valid or not
     */
    private boolean isValidTo(int toRow, int toCol) {
        if (isValidSlot(this.board.length, toRow, toCol)) {
            if (board[toRow][toCol] == Piece.EMPTY) {
                //System.out.println("valid to");
                return true;
            }
        }
        return false;
    }

    /**
     * A helper method to check whether the “to” and “from” positions are exactly two positions away (horizontally or vertically)
     * @param fromRow the row of the from cell
     * @param fromCol the column of the from cell
     * @param toRow the row of the to cell
     * @param toCol the column of the to cell
     * @return a boolean that represents whether the “to” and “from” positions are exactly two positions away
     */
    private boolean isTwoPosAway(int fromRow, int fromCol, int toRow, int toCol) {
        boolean moveVertical = Math.abs(fromRow - toRow) == 2 && (fromCol - toCol) == 0;
        boolean moveHorizontal = Math.abs(fromCol - toCol) == 2 && (fromRow - toRow) == 0;
        return moveVertical || moveHorizontal;
    }

    /**
     * A helper method to check whether there's a slot between the two positions
     * @param fromRow the row of the from cell
     * @param fromCol the column of the from cell
     * @param toRow the row of the to cell
     * @param toCol the column of the to cell
     * @return a boolean that represents whether there's a slot between the two positions
     */
    private boolean isSlotBetween(int fromRow, int fromCol, int toRow, int toCol) {
        int rowInBetween = (fromRow + toRow) / 2;
        int colInBetween = (fromCol + toCol) / 2;
        if (board[rowInBetween][colInBetween] == Piece.MARBLE) {
            return true;
        }
        return false;
    }

    /**
     * A helper method to check whether the position is out of the bound
     * @param row the row of the position
     * @param col the column of the position
     * @return a boolean that represent whether the position is out of the bound
     */
    private boolean isOutOfBound(int row, int col) {
        if (row < 0 || col < 0 || row >= getBoardSize(this.armThickness) || col >= getBoardSize(this.armThickness)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isGameOver() {
        int size = getBoardSize(this.armThickness);
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size ; j++) {
                if (board[i][j] == Piece.MARBLE) {
                    if (canMove(i, j, i + 2, j)) {
                        return false;
                    }
                    if (canMove(i, j, i - 2, j)) {
                        return false;
                    }
                    if (canMove(i, j, i, j - 2)) {
                        return false;
                    }
                    if (canMove(i, j, i, j + 2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String getGameState() {
        String boardStr = "";
        int size = board.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boardStr = boardStr + board[i][j] + " ";
            }
            boardStr = boardStr.substring(0, boardStr.length() - 1) + "\n";
        }
        return boardStr.substring(0, boardStr.length() - 1);
    }

    @Override
    public int getScore() {
        int score = 0;
        int size = getBoardSize(this.armThickness);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == Piece.MARBLE) {
                    score++;
                }
            }
        }
        return score;
    }

}
