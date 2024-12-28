package Projects.ChessGame.Chess.ChessPieces;

import Projects.ChessGame.BoardGame.Board;
import Projects.ChessGame.BoardGame.Position;
import Projects.ChessGame.Chess.ChessPiece;
import Projects.ChessGame.Chess.Color;

public class King extends ChessPiece
{
    public King(Board board, Color color){
        super(board, color);
    }

    private boolean canMoveToPos(Position desiredPos)
    {
        ChessPiece pieceAtPos = (ChessPiece) getBoard().getPiece(desiredPos);

        return  pieceAtPos == null || pieceAtPos.getColor() != this.getColor();
    }

    @Override
    public boolean[][] possibleMoves() 
    {
        boolean[][] boolMat = new boolean[getBoard().getRowsNumber()][getBoard().getColumnsNumber()];
        Position nextPos = new Position(0, 0);
        
        //above
        nextPos.setCoordinates(piecePos.getRow() - 1, piecePos.getColumn());
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            boolMat[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        //below
        nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn());
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            boolMat[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        //left
        nextPos.setCoordinates(piecePos.getRow(), piecePos.getColumn() - 1);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            boolMat[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        //right
        nextPos.setCoordinates(piecePos.getRow(), piecePos.getColumn() + 1);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            boolMat[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        //north West
        nextPos.setCoordinates(piecePos.getRow() - 1, piecePos.getColumn() - 1);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            boolMat[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        //north East
        nextPos.setCoordinates(piecePos.getRow() - 1, piecePos.getColumn() + 1);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            boolMat[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        //south West
        nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn() - 1);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            boolMat[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        //south East
        nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn() + 1);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            boolMat[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        return boolMat;
    }

    @Override
    public String toString() {
        return "K";
    }
}