package Projects.ChessGame.Chess.ChessPieces;

import Projects.ChessGame.BoardGame.Board;
import Projects.ChessGame.BoardGame.Position;
import Projects.ChessGame.Chess.ChessMatch;
import Projects.ChessGame.Chess.ChessPiece;
import Projects.ChessGame.Chess.Color;

public class Pawn extends ChessPiece
{
    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch)
    {
        super(board, color);
        this.chessMatch = chessMatch;
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

            //Special Move: En passant (white)
            if(piecePos.getRow() == 3)
            {
                Position leftPos = new Position(piecePos.getRow(), piecePos.getColumn() - 1);

                if(getBoard().doesPosExist(leftPos) && isThereEnemyAt(leftPos) && getBoard().getPieceAt(leftPos).equals(chessMatch.getEnPassant_VulnerablePiece())) {
                    possiblesMatrix[leftPos.getRow() - 1][leftPos.getColumn()] = true;
                }

                Position rightPos = new Position(piecePos.getRow(), piecePos.getColumn() + 1);

                if(getBoard().doesPosExist(rightPos) && isThereEnemyAt(rightPos) && getBoard().getPieceAt(rightPos).equals(chessMatch.getEnPassant_VulnerablePiece())) {
                    possiblesMatrix[rightPos.getRow() - 1][rightPos.getColumn()] = true;
                }
            }
        }

        else
        {
            //Bellow
            nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn());

            if(getBoard().doesPosExist(nextPos) && !getBoard().isTherePieceAtPos(nextPos)){
                possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
            }
            
            //2 houses Bellow
            nextPos.setCoordinates(piecePos.getRow() + 2, piecePos.getColumn());
            Position forwardPos = new Position(piecePos.getRow() + 1, piecePos.getColumn());
            
            if(getBoard().doesPosExist(nextPos) && !getBoard().isTherePieceAtPos(nextPos) && 
               getBoard().doesPosExist(forwardPos) && !getBoard().isTherePieceAtPos(forwardPos) && 
               getMoveCount() == 0)
            {
                possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
            }
                        
                        
            //Left Diagonal
            nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn() - 1);
            
            if(getBoard().doesPosExist(nextPos) && isThereEnemyAt(nextPos)){
                possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
            }
            
            //Right Diagonal
            nextPos.setCoordinates(piecePos.getRow() + 1, piecePos.getColumn() + 1);
            
            if(getBoard().doesPosExist(nextPos) && isThereEnemyAt(nextPos)){
                possiblesMatrix[nextPos.getRow()][nextPos.getColumn()] = true;
            }
        }

        //Special Move: En passant (black)
        if(piecePos.getRow() == 4)
        {
            Position leftPos = new Position(piecePos.getRow(), piecePos.getColumn() - 1);

            if(getBoard().doesPosExist(leftPos) && isThereEnemyAt(leftPos) && getBoard().getPieceAt(leftPos).equals(chessMatch.getEnPassant_VulnerablePiece())) {
                possiblesMatrix[leftPos.getRow() + 1][leftPos.getColumn()] = true;
            }

            Position righPos = new Position(piecePos.getRow(), piecePos.getColumn() + 1);

            if(getBoard().doesPosExist(righPos) && isThereEnemyAt(righPos) && getBoard().getPieceAt(righPos).equals(chessMatch.getEnPassant_VulnerablePiece())) {
                possiblesMatrix[righPos.getRow() + 1][righPos.getColumn()] = true;
            }
        }

        return possiblesMatrix;
    }

    @Override
    public String toString() {
        return "P";
    }
}