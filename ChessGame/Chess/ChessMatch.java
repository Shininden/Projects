package Projects.ChessGame.Chess;

import Projects.ChessGame.BoardGame.Board;
import Projects.ChessGame.ChessPieces.King;
import Projects.ChessGame.ChessPieces.Rook;

public class ChessMatch 
{
    private Board board;
    private final int ROWS = 8;
    private final int COLUMNS = 8;

    public ChessMatch() 
    {
        this.board = new Board(ROWS, COLUMNS);
        initialSetup();
    }

    public ChessPiece[][] getPiecesMatrix()
    {
        ChessPiece[][] chessMatrix = new ChessPiece[board.getRowsNumber()][board.getColumnsNumber()];

        for (int i = 0; i < chessMatrix.length; i++) 
        {
            for (int j = 0; j < chessMatrix[i].length; j++) {
                chessMatrix[i][j] = (ChessPiece) board.getPiece(i, j);
            }
        }

        return chessMatrix;
    }

    private void placeNewPiece(char column, int row, ChessPiece chessPiece){
        board.placePiece( chessPiece ,  new ChessPosition(column, row).chess_to_MatrixPos() );
    }

    private void initialSetup()
    {
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }
}