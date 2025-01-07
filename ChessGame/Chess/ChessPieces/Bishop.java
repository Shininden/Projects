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

    private boolean canKeepMoving(Position nextPosi){
        return getBoard().doesPosExist(nextPosi)  &&  !getBoard().isTherePieceAtPos(nextPosi);
    }

    private boolean canKillEnemy(Position nextPosi){
        return getBoard().doesPosExist(nextPosi)  &&  isThereEnemyAt(nextPosi);
    }

    @Override
    public boolean[][] possibleMoves() 
    {
        boolean[][] possiblesMatrix = new boolean[getBoard().getRowsNumber()][getBoard().getColumnsNumber()];
        
        Position nextPos = new Position(0, 0);

        //checking if there's available places north west
        nextPos.setCoordinates(piecePos.getRow() - 1, piecePos.getColumn() - 1);

        while (canKeepMoving(nextPos)) 
        {
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
            nextPos.setCoordinates(nextPos.getRow() - 1, nextPos.getColumn() - 1);
        }
        if(canKillEnemy(nextPos)){
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
        }

        //checking if there's available places north east
        nextPos.setCoordinates(piecePos.getRow() - 1, piecePos.getColumn() + 1);

        while (canKeepMoving(nextPos)) 
        {
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
            nextPos.setCoordinates(nextPos.getRow() - 1, nextPos.getColumn() + 1);
        }
        if(canKillEnemy(nextPos)){
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
        }

        //checking if there's available places south east
        nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn() + 1);

        while (canKeepMoving(nextPos)) 
        {
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
            nextPos.setCoordinates(nextPos.getRow() + 1, nextPos.getColumn() + 1);
        }
        if(canKillEnemy(nextPos)){
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
        }

        //checking if there's available places south west
        nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn() - 1);

        while (canKeepMoving(nextPos)) 
        {
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
            nextPos.setCoordinates(nextPos.getRow() + 1, nextPos.getColumn() - 1);
        }
        if(canKillEnemy(nextPos)){
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
        }

        return possiblesMatrix;
    }

    @Override
    public String toString() {
        return "B";
    }
}