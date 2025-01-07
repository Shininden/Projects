package Projects.ChessGame.Application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Projects.ChessGame.Chess.ChessException;
import Projects.ChessGame.Chess.ChessMatch;
import Projects.ChessGame.Chess.ChessPiece;
import Projects.ChessGame.Chess.ChessPosition;

public class MainProgram 
{
   public static void main(String[] args) 
   {
      Scanner sc = new Scanner(System.in);
      ChessMatch match = new ChessMatch();
      List<ChessPiece> capturesList = new ArrayList<>();

      while (!match.isInCheckMate()) 
      {
         try 
         {
            UI.clearScreen();
            UI.printMatch(match, capturesList);

            System.out.println();
   
            System.out.print("Source: ");
            ChessPosition source = UI.readChessPos(sc);
            boolean[][] possibleSlots = match.slotsToMoveTo(source);
            
            UI.clearScreen();
            UI.printBoard(match.getPiecesMatrix(), possibleSlots);
   
            System.out.println();

            System.out.print("Target: ");
            ChessPosition target = UI.readChessPos(sc);
   
            ChessPiece capturedPiece = match.perfomChessMove(source, target);
            
            if(capturedPiece != null){
               capturesList.add(capturedPiece);
            }

            if(match.getPromotedPawn() != null)
            {
               System.out.print("Which piece would you like to promote the pawn to? (B/N/R/Q) ");
               String type = sc.nextLine();
               
               while(!type.equalsIgnoreCase("B") && !type.equalsIgnoreCase("N") && !type.equalsIgnoreCase("R") && !type.equalsIgnoreCase("Q"))
               {
                  System.out.print("Invalid Type for promotion!! (B/N/R/Q) ");
                  type = sc.nextLine();
               }   

               match.replacePromotedPiece(type);
            }
         } 
         catch (ChessException e) 
         {
            System.err.println(e.getMessage());
            sc.nextLine();
         }
         catch(InputMismatchException e)
         {
            System.err.println(e.getMessage());
            sc.nextLine();
         }
      }

      UI.clearScreen();
      UI.printMatch(match, capturesList);
   }
}