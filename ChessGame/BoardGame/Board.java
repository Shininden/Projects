package Projects.ChessGame.BoardGame;

public class Board 
{
    private int rowsNumber;
    private int columnsNumber;
    private Piece[][] piecesMatrix;

    public Board(int rows, int columns) 
    {
        this.rowsNumber = rows;
        this.columnsNumber = columns;
        piecesMatrix = new Piece[rows][columns];
    }

    public void placePiece(Piece piece, Position pos)
    {
        if(isTherePieceAtPos(pos)){
            throw new BoardException("Invalid Position, there is already a piece at the position " + pos);
        }
        else
        {
            piecesMatrix[pos.getRow()][pos.getColumn()] = piece;
            piece.pos = pos;
        }
    }

    private boolean doesPosExist(int row, int column){
        return ( row >= 0 && row < getRowsNumber() ) && ( column >= 0 && column < getColumnsNumber() );
    }
    public boolean doesPosExist(Position pos){
        return doesPosExist(pos.getRow(), pos.getColumn());
    }

    public boolean isTherePieceAtPos(Position pos)
    {
        if(!doesPosExist(pos)){
            throw new BoardException("Invalid Position");
        }

        return getPiece(pos) != null;
    }





    public int getRowsNumber() {
        return rowsNumber;
    }
    public int getColumnsNumber() {
        return columnsNumber;
    }

    public Piece getPiece(int row, int column)
    {
        if(!doesPosExist(row, column)){
            throw new BoardException("Invalid Position");
        }

        return piecesMatrix[row][column];
    }

    public Piece getPiece(Position pos)
    {
        if(!doesPosExist(pos)){
            throw new BoardException("Invalid Position");
        }
        
        return piecesMatrix[ pos.getRow()][pos.getColumn() ];
    }
}