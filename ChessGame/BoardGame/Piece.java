package Projects.ChessGame.BoardGame;

public class Piece 
{
    protected Position pos;
    private Board board;

    public Piece(Board board) 
    {
        this.board = board;
        this.pos = null;
    }

    protected Board getBoard() {
        return board;
    }
}