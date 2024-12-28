package Projects.ChessGame.Chess.ChessPieces;

import Projects.ChessGame.BoardGame.Board;
import Projects.ChessGame.BoardGame.Position;
import Projects.ChessGame.Chess.ChessPiece;
import Projects.ChessGame.Chess.Color;

public class Pawn extends ChessPiece
{
    public Pawn(Board board, Color color){
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() 
    {
        
        boolean[][] possiblesMatrix = new boolean[getBoard().getRowsNumber()][getBoard().getColumnsNumber()];
        
        Position nextPos = new Position(0, 0);

        if(getColor() == Color.WHITE)
        {
            //Above
            nextPos.setCoordinates(piecePos.getRow() - 1, piecePos.getColumn());

            if(getBoard().doesPosExist(nextPos) && !getBoard().isTherePieceAtPos(nextPos)){
                possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
            }

            //2 houses above
            nextPos.setCoordinates(piecePos.getRow() - 2, piecePos.getColumn());
            Position forwardPos = new Position(piecePos.getRow() - 1, piecePos.getColumn());

            if(getBoard().doesPosExist(nextPos) && !getBoard().isTherePieceAtPos(nextPos) && 
               getBoard().doesPosExist(forwardPos) && !getBoard().isTherePieceAtPos(forwardPos) && 
               getMoveCount() == 0)
            {
                possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
            }
            
            
            //Left Diagonal
            nextPos.setCoordinates(piecePos.getRow() - 1, piecePos.getColumn() - 1);

            if(getBoard().doesPosExist(nextPos) && isThereEnemyAt(nextPos)){
                possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
            }

            //Right Diagonal
            nextPos.setCoordinates(piecePos.getRow() - 1, piecePos.getColumn() + 1);

            if(getBoard().doesPosExist(nextPos) && isThereEnemyAt(nextPos)){
                possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
            }
        }

        else
        {
            //Above
            nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn());

            if(getBoard().doesPosExist(nextPos) && !getBoard().isTherePieceAtPos(nextPos)){
                possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
            }
            
            //2 houses above
            nextPos.setCoordinates(piecePos.getRow() + 2, piecePos.getColumn());
            Position forwardPos = new Position(piecePos.getRow() + 1, piecePos.getColumn());
            
            if(getBoard().doesPosExist(nextPos) && !getBoard().isTherePieceAtPos(nextPos) && 
               getBoard().doesPosExist(forwardPos) && !getBoard().isTherePieceAtPos(forwardPos) && 
               getMoveCount() == 0)
            {
                possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
            }
                        
                        
            //Left Diagonal
            nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn() + 1);
            
            if(getBoard().doesPosExist(nextPos) && isThereEnemyAt(nextPos)){
                possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
            }
            
            //Right Diagonal
            nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn() + 1);
            
            if(getBoard().doesPosExist(nextPos) && isThereEnemyAt(nextPos)){
                possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
            }
        }

        return possiblesMatrix;
    }

    @Override
    public String toString() {
        return "P";
    }
}