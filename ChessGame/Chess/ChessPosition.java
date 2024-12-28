package Projects.ChessGame.Chess;

import Projects.ChessGame.BoardGame.Position;

public class ChessPosition 
{
    private char charColumn;
    private final static  int MINIMUM_CHAR = 'a';
    private final int MAXIMUM_CHAR = 'h';
    
    
    private int numericalRow;
    private final int MINIMUM_INT = 1;
    private final static int MAXIMUM_INT = 8;
        
    public ChessPosition(char charColumn, int numericalRow) 
    {
        if(charColumn < MINIMUM_CHAR || charColumn > MAXIMUM_CHAR || 
          numericalRow < MINIMUM_INT || numericalRow > MAXIMUM_INT )
        {
            throw new ChessException("Error: values must be between a1 to h8");
        }
        
        this.charColumn = charColumn;
        this.numericalRow = numericalRow;      
    }
        
    protected Position chess_to_MatrixPos(){
        return new Position(MAXIMUM_INT - numericalRow, charColumn - MINIMUM_CHAR);
    }
        
    protected static ChessPosition matrix_to_ChessPos(Position pos){
        return new ChessPosition( (char) (MINIMUM_CHAR + pos.getColumn()),  MAXIMUM_INT - pos.getRow() );
    }


    @Override
    public String toString() {
        return "" + getCharColumn() + getNumericalRow();
    }

    public char getCharColumn() {
        return charColumn;
    }
    public int getNumericalRow() {
        return numericalRow;
    }   
}