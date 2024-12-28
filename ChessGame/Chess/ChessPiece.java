package Projects.ChessGame.Chess;

import Projects.ChessGame.BoardGame.Board;
import Projects.ChessGame.BoardGame.Piece;
import Projects.ChessGame.BoardGame.Position;

public abstract class ChessPiece extends Piece
{
    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) 
    {
        super(board);
        this.color = color;
    }

    protected boolean isThereEnemyAt(Position pos)
    {
        ChessPiece enemyPiece = (ChessPiece) getBoard().getPiece(pos);
        
        return enemyPiece != null  &&  enemyPiece.getColor() != this.color;
    }

    public void increaseMoveCount(){
        this.moveCount++;
    }
    public void decreaseMoveCount(){
        this.moveCount--;
    }

    public ChessPosition getChessPosition(){
        return ChessPosition.matrix_to_ChessPos(piecePos);
    } 

    public Color getColor() {
        return color;
    }

    public int getMoveCount() {
        return moveCount;
    }
}