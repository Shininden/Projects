package Projects.ChessGame.Chess;

import Projects.ChessGame.BoardGame.Board;
import Projects.ChessGame.BoardGame.Piece;

public class ChessPiece extends Piece
{
    private Color color;

    public ChessPiece(Board board, Color color) 
    {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}