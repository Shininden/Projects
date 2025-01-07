package Projects.ChessGame.Chess.ChessPieces;

import Projects.ChessGame.BoardGame.Board;
import Projects.ChessGame.BoardGame.Position;
import Projects.ChessGame.Chess.ChessPiece;
import Projects.ChessGame.Chess.Color;

public class Knight  extends ChessPiece
{
    public Knight(Board board, Color color){
        super(board, color);
    }

    private boolean canMoveToPos(Position desiredPos)
    {
        ChessPiece pieceAtPos = (ChessPiece) getBoard().getPieceAt(desiredPos);

        return pieceAtPos == null || pieceAtPos.getColor() != this.getColor();
    }

    @Override
    public boolean[][] possibleMoves() 
    {
        boolean[][] possiblesMatrix = new boolean[getBoard().getRowsNumber()][getBoard().getColumnsNumber()];
        
        Position nextPos = new Position(0, 0);
        
        nextPos.setCoordinates(piecePos.getRow() - 1, piecePos.getColumn() - 2);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        nextPos.setCoordinates(piecePos.getRow() - 2, piecePos.getColumn() - 1);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        nextPos.setCoordinates(piecePos.getRow() - 2, piecePos.getColumn() + 1);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        nextPos.setCoordinates(piecePos.getRow() - 1, piecePos.getColumn() + 2);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn() + 2);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        nextPos.setCoordinates(piecePos.getRow() + 2, piecePos.getColumn() + 1);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        nextPos.setCoordinates(piecePos.getRow() + 2, piecePos.getColumn() - 1);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn() - 2);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        return possiblesMatrix;
    }

    @Override
    public String toString() {
        return "N";
    }
}
