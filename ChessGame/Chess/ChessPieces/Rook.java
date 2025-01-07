package Projects.ChessGame.Chess.ChessPieces;

import Projects.ChessGame.BoardGame.Board;
import Projects.ChessGame.BoardGame.Position;
import Projects.ChessGame.Chess.ChessPiece;
import Projects.ChessGame.Chess.Color;

public class Rook extends ChessPiece
{
    public Rook(Board board, Color color){
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

        //checking if there's available places above
        nextPos.setCoordinates(piecePos.getRow() - 1, piecePos.getColumn());
        while (canKeepMoving(nextPos)) 
        {
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
            nextPos.setRow(nextPos.getRow() - 1);
        }
        if(canKillEnemy(nextPos)){
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
        }

        //checking if there's available places below
        nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn());
        while (canKeepMoving(nextPos)) 
        {
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
            nextPos.setRow(nextPos.getRow() + 1);
        }
        if(canKillEnemy(nextPos)){
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
        }

        //checking if there's available places on the left
        nextPos.setCoordinates(piecePos.getRow(), piecePos.getColumn() - 1);
        while (canKeepMoving(nextPos)) 
        {
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
            nextPos.setColumn(nextPos.getColumn() - 1);
        }
        if(canKillEnemy(nextPos)){
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
        }

        //checking if there's available places on the right
        nextPos.setCoordinates(piecePos.getRow(), piecePos.getColumn() + 1);
        while (canKeepMoving(nextPos)) 
        {
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
            nextPos.setColumn(nextPos.getColumn() + 1);
        }
        if(canKillEnemy(nextPos)){
            possiblesMatrix[ nextPos.getRow()][nextPos.getColumn() ] = true;
        }

        return possiblesMatrix;
    }

    @Override
    public String toString() {
        return "R";
    }
}