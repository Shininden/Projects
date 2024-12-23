package Projects.ChessGame.BoardGame;

public class Board 
{
    private int rows;
    private int columns;
    private PieceBaseLogic[][] pieces;

    public Board(int rows, int columns) 
    {
        this.rows = rows;
        this.columns = columns;
        pieces = new PieceBaseLogic[rows][columns];
    }

    public PieceBaseLogic getPiece(int row, int column){
        return pieces[row][column];
    }
    public PieceBaseLogic getPiece(Position pos){
        return pieces[ pos.getRow()][pos.getColumn() ];
    }

    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }
    public void setColumns(int columns) {
        this.columns = columns;
    }
}