package Projects.ChessGame.Chess.ChessPieces;

import Projects.ChessGame.BoardGame.Board;
import Projects.ChessGame.BoardGame.Position;
import Projects.ChessGame.Chess.ChessPiece;
import Projects.ChessGame.Chess.Color;

public class Bishop extends ChessPiece
{
    public Bishop(Board board, Color color){
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() 
    {
        boolean[][] possiblesMatrix = new boolean[getBoard().getRowsNumber()][getBoard().getColumnsNumber()];
        
        Position nextPos = new Position(0, 0);

        //checking if there's available places north west
        nextPos.setCoordinates(piecePos.getRow() - 1, piecePos.getColumn() - 1);

        while (getBoard().doesPosExist(nextPos)  &&  !getBoard().isTherePieceAtPos(nextPos)) 
        {
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
            nextPos.setCoordinates(nextPos.getRow() - 1, nextPos.getColumn() - 1);
        }
        if(getBoard().doesPosExist(nextPos)  &&  isThereEnemyAt(nextPos)){
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
        }

        //checking if there's available places north east
        nextPos.setCoordinates(piecePos.getRow() - 1, piecePos.getColumn() + 1);

        while (getBoard().doesPosExist(nextPos)  &&  !getBoard().isTherePieceAtPos(nextPos)) 
        {
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
            nextPos.setCoordinates(nextPos.getRow() - 1, nextPos.getColumn() + 1);
        }
        if(getBoard().doesPosExist(nextPos)  &&  isThereEnemyAt(nextPos)){
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
        }

        //checking if there's available places south east
        nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn() + 1);

        while (getBoard().doesPosExist(nextPos)  &&  !getBoard().isTherePieceAtPos(nextPos)) 
        {
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
            nextPos.setCoordinates(nextPos.getRow() + 1, nextPos.getColumn() + 1);
        }
        if(getBoard().doesPosExist(nextPos)  &&  isThereEnemyAt(nextPos)){
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
        }

        //checking if there's available places south west
        nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn() - 1);

        while (getBoard().doesPosExist(nextPos)  &&  !getBoard().isTherePieceAtPos(nextPos)) 
        {
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
            nextPos.setCoordinates(nextPos.getRow() + 1, nextPos.getColumn() - 1);
        }
        if(getBoard().doesPosExist(nextPos)  &&  isThereEnemyAt(nextPos)){
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
        }

        return possiblesMatrix;
    }

    @Override
    public String toString() {
        return "B";
    }
}