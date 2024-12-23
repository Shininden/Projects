package Projects.ChessGame.Chess;

import Projects.ChessGame.BoardGame.Board;
import Projects.ChessGame.BoardGame.PieceBaseLogic;

public class ChessPiece extends PieceBaseLogic
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