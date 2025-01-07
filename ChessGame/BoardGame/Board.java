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
            piece.piecePos = pos;
        }
    }

    public Piece removePieceAt(Position pos)
    {
        if(!doesPosExist(pos)){
            throw new BoardException("Invalid Position");
        }

        if(getPieceAt(pos) == null){
            return null;
        }
        else
        {
            Piece tempHolder = getPieceAt(pos);
            tempHolder.piecePos = null;
            piecesMatrix[pos.getRow()][pos.getColumn()] = null;
            return tempHolder;
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

        return getPieceAt(pos) != null;
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

    public Piece getPieceAt(Position pos)
    {
        if(!doesPosExist(pos)){
            throw new BoardException("Invalid Position, it does not exist");
        }
        
        return piecesMatrix[ pos.getRow()][pos.getColumn() ];
    }
}