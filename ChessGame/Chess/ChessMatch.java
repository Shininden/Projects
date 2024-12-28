package Projects.ChessGame.Chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Projects.ChessGame.BoardGame.Board;
import Projects.ChessGame.BoardGame.Piece;
import Projects.ChessGame.BoardGame.Position;
import Projects.ChessGame.Chess.ChessPieces.Bishop;
import Projects.ChessGame.Chess.ChessPieces.King;
import Projects.ChessGame.Chess.ChessPieces.Pawn;
import Projects.ChessGame.Chess.ChessPieces.Rook;

public class ChessMatch 
{
    private Board board;
    private final int ROWS = 8;
    private final int COLUMNS = 8;

    private int turn;
    private Color currPlayerColor;

    List<Piece> capturesList = new ArrayList<>();
    List<Piece> piecesOnBoardList = new ArrayList<>();

    private boolean isInCheck;
    private boolean isInCheckMate;

    public ChessMatch() 
    {
        this.board = new Board(ROWS, COLUMNS);
        turn = 1;
        currPlayerColor = Color.WHITE;
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

    public boolean[][] slotsToMoveTo(ChessPosition sourcePos)
    {
        Position matrixPos = sourcePos.chess_to_MatrixPos();
        validateSourcePos(matrixPos);
        
        return board.getPiece(matrixPos).possibleMoves();
    }

    public ChessPiece perfomChessMove(ChessPosition sourcePos, ChessPosition targetPos)
    {
        Position source = sourcePos.chess_to_MatrixPos();
        Position target = targetPos.chess_to_MatrixPos();

        validateSourcePos(source);
        validateTargetPos(source, target);
        
        Piece capturedPiece = makeMove(source, target);

        if(testForCheck(currPlayerColor))
        {
            undoMove(source, target, capturedPiece);
            throw new ChessException("You can't put yourself in check");
        }

        isInCheck = (  testForCheck (getEnemyOf(currPlayerColor))  )  ?  true : false;

        if( testForCheckMate( getEnemyOf(currPlayerColor) ) ) {
            isInCheckMate = true;
        }
        else{
            nextTurn();
        }
        
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target)
    {
        ChessPiece movedPiece = (ChessPiece) board.removePiece(source);
        movedPiece.increaseMoveCount();

        Piece capturedPiece = board.removePiece(target);

        board.placePiece(movedPiece, target);

        if(capturedPiece != null)
        {
            capturesList.add(capturedPiece);
            piecesOnBoardList.remove(capturedPiece);
        }

        return capturedPiece;
    }

    private void undoMove(Position source, Position target, Piece capturedPiece)
    {
        ChessPiece movedPiece = (ChessPiece) board.removePiece(target);
        movedPiece.decreaseMoveCount();
        
        board.placePiece(movedPiece, source);

        if(capturedPiece != null)
        {
            board.placePiece(capturedPiece, target);

            capturesList.remove(capturedPiece);
            piecesOnBoardList.add(capturedPiece);
        }
    }

    private void placeNewPiece(char column, int row, ChessPiece chessPiece)
    {
        board.placePiece( chessPiece ,  new ChessPosition(column, row).chess_to_MatrixPos() );
        piecesOnBoardList.add(chessPiece);
    }

    private void nextTurn()
    {
        turn++;
        currPlayerColor =  (currPlayerColor == Color.WHITE) ?  Color.BLACK : Color.WHITE;
    }
    
    private void initialSetup()
    {
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE));
        placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
        placeNewPiece('a', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('b', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('c', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('d', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('e', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('f', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('g', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('h', 2, new Pawn(board, Color.WHITE));

        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));
        placeNewPiece('a', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('b', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('c', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('d', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('e', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('f', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('g', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('h', 7, new Pawn(board, Color.BLACK));
    }

    private void validateSourcePos(Position pos)
    {
        if(!board.isTherePieceAtPos(pos)){
            throw new ChessException("There is no piece at source position");
        }

        if(currPlayerColor != ( (ChessPiece) board.getPiece(pos) ).getColor()) {
            throw new ChessException("The chosen piece is not yours");
        }

        if(!board.getPiece(pos).isThereAnyPossibleMoves()){
            throw new ChessException("Error: There is no possible moves for the chosen piece");
        }
    }
    private void validateTargetPos(Position sourcePos, Position targetPos)
    {
        if(!board.getPiece(sourcePos).isMovePossible(targetPos)){
            throw new ChessException("Moving to the desired position is impossible");
        }
    }

    private boolean testForCheck(Color kingColor)
    {
        Position kingPos = getKing(kingColor).getChessPosition().chess_to_MatrixPos();
        List<Piece> enemyPieces = piecesOnBoardList.stream().filter(x -> ( (ChessPiece) x).getColor() == getEnemyOf(kingColor)).collect(Collectors.toList());
        
        for (Piece enemyPiece : enemyPieces) 
        {
            boolean[][] possibleSlots = enemyPiece.possibleMoves();
            
            if(possibleSlots[kingPos.getRow()][kingPos.getColumn()]){
                return true;
            }
        }

        return false;
    }
    
    private boolean testForCheckMate(Color kingColor)
    {
        if(!testForCheck(kingColor)){
            return false;
        }

        List<Piece> kingSubjects = piecesOnBoardList.stream().filter(x -> ( (ChessPiece) x).getColor() == kingColor).collect(Collectors.toList());
        
        for (Piece subject : kingSubjects) 
        {
            boolean[][] subjectPossibleMoves = subject.possibleMoves();

            for (int i = 0; i < board.getRowsNumber(); i++) 
            {
                for (int j = 0; j < board.getColumnsNumber(); j++) 
                {
                    if(subjectPossibleMoves[i][j])
                    {
                        Position source = ( (ChessPiece) subject).getChessPosition().chess_to_MatrixPos();
                        Position target = new Position(i, j);
                        Piece capturedPiece = makeMove(source, target);

                        boolean isInCheck = testForCheck(kingColor);
                        undoMove(source, target, capturedPiece);

                        if(!isInCheck){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private Color getEnemyOf(Color color){
        return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }   

    private ChessPiece getKing(Color color)
    {
        List<Piece> piecesList = piecesOnBoardList.stream().filter(x -> ( (ChessPiece) x).getColor() == color).collect(Collectors.toList());
        
        for (Piece piece : piecesList) 
        {
            if(piece instanceof King){
                return (ChessPiece) piece;
            }
        }

        throw new IllegalStateException("There is no " + color + " king on the board");
    }

    
    public int getTurn() {
        return turn;
    }

    public boolean isInCheck() {
        return isInCheck;
    }
    public boolean isInCheckMate() {
        return isInCheckMate;
    }

    public Color getCurrPlayerColor() {
        return currPlayerColor;
    }
}