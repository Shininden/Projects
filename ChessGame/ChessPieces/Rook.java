package Projects.ChessGame.ChessPieces;

import Projects.ChessGame.BoardGame.Board;
import Projects.ChessGame.Chess.ChessPiece;
import Projects.ChessGame.Chess.Color;

public class Rook extends ChessPiece
{
    public Rook(Board board, Color color){
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }
}