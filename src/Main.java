import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Uses scanner to read the users input
        Scanner sc = new Scanner(System.in);


        //Creates the initial board
        Board board = new Board();

        while (!board.checkForWin()) {
            //Asks the user for what square to place their marker
            System.out.println(""" 
                    Välj en ruta:
                    1 2 3
                    4 5 6
                    7 8 9""");

            //Displays current player
            System.out.println("Current player: " + board.getCurrentPlayer());

            //Prints out the board
            board.printBoard();

            //Stores user input in the numbers variable
            int number = sc.nextInt();
            //takes the users input and converts to a position on the board and places marker if empty
            int[] position = board.convertNumberToPosition(number);
            //Fixes so player get second try if placed on occupied square
            boolean isPlacementSuccessful = board.placeMarker(position[0], position[1], board.getCurrentPlayer());

            //Calls method in board class to check for a win
            if (board.checkForWin()) {
                System.out.println("Player " + board.getCurrentPlayer() + " wins!");
            }
            //If game is a draw
            else if (board.markerCount == 9) {
                break;
            }

            //Changes player
            if (isPlacementSuccessful) {
                board.changePlayer();
            }
        }

    }
}