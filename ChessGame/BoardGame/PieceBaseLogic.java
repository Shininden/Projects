package Projects.ChessGame.BoardGame;

public class PieceBaseLogic 
{
    protected Position pos;
    private Board board;

    public PieceBaseLogic(Board board) 
    {
        this.board = board;
        this.pos = null;
    }

    protected Board getBoard() {
        return board;
    }
}