package Projects.ChessGame.Application;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Projects.ChessGame.Chess.ChessException;
import Projects.ChessGame.Chess.ChessMatch;
import Projects.ChessGame.Chess.ChessPiece;
import Projects.ChessGame.Chess.ChessPosition;
import Projects.ChessGame.Chess.Color;

public class UI 
{
    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	
    //Text colors
    public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void clearScreen()
    {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static ChessPosition readChessPos(Scanner sc)
    {
        try 
        {
            String pos = sc.nextLine();
            char column = pos.charAt(0);
            int row = Integer.parseInt( pos.substring(1) );
            return new ChessPosition(column, row);
        } 
        
        catch (RuntimeException e) {
            throw new ChessException("Error: values must be between a1 to h8");
        }
    }

    public static void printMatch(ChessMatch chessMatch, List<ChessPiece> capturesList)
    {
        printBoard(chessMatch.getPiecesMatrix());
        System.out.println();

        printCapturedPieces(capturesList);

        System.out.println("Turn: " + chessMatch.getTurn());

        if(!chessMatch.isInCheckMate())
        {
            System.out.println("Waiting the move from player: " + chessMatch.getCurrPlayerColor());
        
            if(chessMatch.isInCheck()){
                System.out.println("Check!!!");
            }
        }
        else
        {
            System.out.println("CHECK MATE!!!");
            System.out.println("Winner: " + chessMatch.getCurrPlayerColor());
        }
       
    }

    public static void printBoard(ChessPiece[][] chessPieces)
    {
        for (int i = 0; i < chessPieces.length; i++) 
        {
            System.out.print( (chessPieces.length - i) + " ");
            
            for (int j = 0; j < chessPieces[i].length; j++) {
                printOnePiece(chessPieces[i][j], false);
            }

            System.out.println();
        }

        System.out.println("  a b c d e f g h");
    }

    public static void printBoard(ChessPiece[][] chessPieces, boolean[][] possibleSlots)
    {
        for (int i = 0; i < chessPieces.length; i++) 
        {
            System.out.print( (chessPieces.length - i) + " ");
            
            for (int j = 0; j < chessPieces[i].length; j++) {
                printOnePiece(chessPieces[i][j], possibleSlots[i][j]);
            }

            System.out.println();
        }

        System.out.println("  a b c d e f g h");
    }

    private static void printOnePiece(ChessPiece chessPiece, boolean shoouldColorBG)
    {
        if(shoouldColorBG){
            System.out.print(ANSI_GREEN_BACKGROUND);
        }
        if(chessPiece == null){
            System.out.print("-" + ANSI_RESET + " ");
        }

        else 
        {
            if (chessPiece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + chessPiece + ANSI_RESET + " ");
            }
            else {
                System.out.print(ANSI_BLACK + chessPiece + ANSI_RESET + " ");
            }
        }
    }    

    private static void printCapturedPieces(List<ChessPiece> capturedPieces)
    {
        List<ChessPiece> whitePieces = capturedPieces.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
        List<ChessPiece> blackPieces = capturedPieces.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
        
        System.out.println("Captured Pieces: ");

        System.out.print("\nWhite Pieces: " + ANSI_WHITE);
        System.out.println( Arrays.toString(whitePieces.toArray()) );
        System.out.print(ANSI_RESET);

        System.out.print("Black Pieces: " + ANSI_BLACK);
        System.out.println( Arrays.toString(blackPieces.toArray()) );
        System.out.print(ANSI_RESET+"\n");
    }
}