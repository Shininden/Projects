package Projects.ChessGame.BoardGame;

public abstract class Piece 
{
    protected Position piecePos;
    private Board board;

    public Piece(Board board) 
    {
        this.board = board;
        this.piecePos = null;
    }

    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean isMovePossible(Position pos){
        return possibleMoves()[pos.getRow()][pos.getColumn()];
    }

    public boolean isThereAnyPossibleMoves()
    {
        boolean[][] boolMatrix = possibleMoves();

        for (int i = 0; i < boolMatrix.length; i++) 
        {
            for (int j = 0; j < boolMatrix[i].length; j++) 
            {
                if(boolMatrix[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}