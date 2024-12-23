package Projects.ChessGame.Chess;

import Projects.ChessGame.BoardGame.Board;

public class ChessMatch 
{
    private Board board;

    public ChessMatch() {
        this.board = new Board(8, 8);
    }

    public ChessPiece[][] getPiecesMatrix()
    {
        ChessPiece[][] matrix = new ChessPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i < matrix.length; i++) 
        {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (ChessPiece) board.getPiece(i, j);
            }
        }

        return matrix;
    }
}