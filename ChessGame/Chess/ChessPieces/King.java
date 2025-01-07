package Projects.ChessGame.Chess.ChessPieces;

import Projects.ChessGame.BoardGame.Board;
import Projects.ChessGame.BoardGame.Position;
import Projects.ChessGame.Chess.ChessMatch;
import Projects.ChessGame.Chess.ChessPiece;
import Projects.ChessGame.Chess.Color;

public class King extends ChessPiece
{
    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch)
    {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean canMoveToPos(Position desiredPos)
    {
        ChessPiece pieceAtPos = (ChessPiece) getBoard().getPieceAt(desiredPos);

        return  pieceAtPos == null || pieceAtPos.getColor() != this.getColor();
    }

    @Override
    public boolean[][] possibleMoves() 
    {
        boolean[][] possiblesMatrix = new boolean[getBoard().getRowsNumber()][getBoard().getColumnsNumber()];
        
        Position nextPos = new Position(0, 0);
        
        //above
        nextPos.setCoordinates(piecePos.getRow() - 1, piecePos.getColumn());
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        //below
        nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn());
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        //left
        nextPos.setCoordinates(piecePos.getRow(), piecePos.getColumn() - 1);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        //right
        nextPos.setCoordinates(piecePos.getRow(), piecePos.getColumn() + 1);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        //north West
        nextPos.setCoordinates(piecePos.getRow() - 1, piecePos.getColumn() - 1);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        //north East
        nextPos.setCoordinates(piecePos.getRow() - 1, piecePos.getColumn() + 1);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        //south West
        nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn() - 1);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
        }

        //south East
        nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn() + 1);
        if(getBoard().doesPosExist(nextPos) && canMoveToPos(nextPos)){
            possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
        }


        //Special Move: Castling
        if(getMoveCount() == 0 && !chessMatch.isInCheck())
        {
            //right side
            Position rightRook = new Position(piecePos.getRow(), piecePos.getColumn() + 3);

            if(testRookCastling(rightRook))
            {
                Position p1 = new Position(piecePos.getRow(), piecePos.getColumn() + 1);
                Position p2 = new Position(piecePos.getRow(), piecePos.getColumn() + 2);
                
                if(getBoard().getPieceAt(p1) == null && getBoard().getPieceAt(p2) == null){
                    possiblesMatrix[piecePos.getRow()][p2.getColumn()] = true;
                }
            }

            //left side
            Position leftRook = new Position(piecePos.getRow(), piecePos.getColumn() - 4);

            if(testRookCastling(leftRook))
            {
                Position p1 = new Position(piecePos.getRow(), piecePos.getColumn() - 1);
                Position p2 = new Position(piecePos.getRow(), piecePos.getColumn() - 2);
                Position p3 = new Position(piecePos.getRow(), piecePos.getColumn() - 3);
                
                if(getBoard().getPieceAt(p1) == null && getBoard().getPieceAt(p2) == null && getBoard().getPieceAt(p3) == null){
                    possiblesMatrix[piecePos.getRow()][p2.getColumn()] = true;
                }
            }
        }

        return possiblesMatrix;
    }

    private boolean testRookCastling(Position pos)
    {
        ChessPiece piece = (ChessPiece) getBoard().getPieceAt(pos);

        return piece != null  &&  piece instanceof Rook  &&  piece.getColor() == this.getColor()  &&  piece.getMoveCount() == 0;
    }

    @Override
    public String toString() {
        return "K";
    }
}