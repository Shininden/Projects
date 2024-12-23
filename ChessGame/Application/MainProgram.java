package Projects.ChessGame.Application;

import Projects.ChessGame.Chess.ChessMatch;

public class MainProgram 
{
    public static void main(String[] args) 
    {
       ChessMatch match = new ChessMatch();
        
        UI.printBoard(match.getPiecesMatrix());
    }
}