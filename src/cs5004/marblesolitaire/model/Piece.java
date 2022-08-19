package cs5004.marblesolitaire.model;

/**
 * A Enum represent the marble piece
 */
public enum Piece {
    MARBLE,  INVALID, EMPTY;

    @Override
    public String toString(){
        switch (this){
            case MARBLE:
                return "O";
            case EMPTY:
                return "_";
            case INVALID:
                return " ";
            default:
                return null;
        }
    }
}
