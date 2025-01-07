package Projects.ChessGame.Chess.ChessPieces;

import Projects.ChessGame.BoardGame.Board;
import Projects.ChessGame.BoardGame.Position;
import Projects.ChessGame.Chess.ChessPiece;
import Projects.ChessGame.Chess.Color;

public class Queen extends ChessPiece
{
    public Queen(Board board, Color color){
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() 
    {
        boolean[][] possiblesMatrix = new boolean[getBoard().getRowsNumber()][getBoard().getColumnsNumber()];
        
        Position nextPos = new Position(0, 0);

        //checking if there's available places above
        nextPos.setCoordinates(piecePos.getRow() - 1, piecePos.getColumn());

        while (getBoard().doesPosExist(nextPos)  &&  !getBoard().isTherePieceAtPos(nextPos)) 
        {
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
            nextPos.setRow(nextPos.getRow() - 1);
        }
        if(getBoard().doesPosExist(nextPos)  &&  isThereEnemyAt(nextPos)){
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
        }

        //checking if there's available places below
        nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn());

        while (getBoard().doesPosExist(nextPos)  &&  !getBoard().isTherePieceAtPos(nextPos)) 
        {
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
            nextPos.setRow(nextPos.getRow() + 1);
        }
        if(getBoard().doesPosExist(nextPos)  &&  isThereEnemyAt(nextPos)){
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
        }

        //checking if there's available places on the left
        nextPos.setCoordinates(piecePos.getRow(), piecePos.getColumn() - 1);

        while (getBoard().doesPosExist(nextPos)  &&  !getBoard().isTherePieceAtPos(nextPos)) 
        {
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
            nextPos.setColumn(nextPos.getColumn() - 1);
        }
        if(getBoard().doesPosExist(nextPos)  &&  isThereEnemyAt(nextPos)){
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
        }

        //checking if there's available places on the right
        nextPos.setCoordinates(piecePos.getRow(), piecePos.getColumn() + 1);

        while (getBoard().doesPosExist(nextPos)  &&  !getBoard().isTherePieceAtPos(nextPos)) 
        {
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
            nextPos.setColumn(nextPos.getColumn() + 1);
        }
        if(getBoard().doesPosExist(nextPos)  &&  isThereEnemyAt(nextPos)){
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
        }

        

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
        return "Q";
    }
}