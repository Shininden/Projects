package Projects.ChessGame.Application;

import Projects.ChessGame.Chess.ChessPiece;

public class UI 
{
    public static void printBoard(ChessPiece[][] chessPieces)
    {
        for (int i = 0; i < chessPieces.length; i++) 
        {
            System.out.print( (chessPieces.length - i) + " ");
            
            for (int j = 0; j < chessPieces[i].length; j++) {
                printOnePiece(chessPieces[i][j]);
            }

            System.out.println();
        }

        System.out.println("  a b c d e f g h");
    }

    private static void printOnePiece(ChessPiece chessPiece)
    {
        if(chessPiece == null){
            System.out.print("- ");
        }

        else{
            System.out.println(chessPiece + " ");
        }
    }
}