import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Uses scanner to read the users input
        Scanner sc = new Scanner(System.in);
        String currentPlayer = "X";
        //If game over set gameOver = true
        boolean gameOver = false;

        //Creates the initial board
        Board board = new Board();
        Player player = new Player();

        while (!gameOver) {
            //calls the printBoard method in the board class
            board.printBoard();
            System.out.println("Current player: " + currentPlayer);
            System.out.println("Enter row and column:");
            //Stores user input in the numbers variable
            int number = sc.nextInt();
            //takes the users input and converts to a usable variable and places marker if empty
            int[] position = board.convertNumberToPosition(number);
            board.placeMarker(position[0], position[1], currentPlayer);


            //Checks for a winner
            String[][] gameBoard = board.getGameBoard();
            for (int i = 0; i < gameBoard.length - 2; i++) {
                for (int j = 0; j < gameBoard[i].length; j++) {
                    if (gameBoard[i][j] != null && !gameBoard[i][j].equals(" ") && gameBoard[i][j].equals(gameBoard[i+1][j]) && gameBoard[i][j].equals(gameBoard[i+2][j])) {
                        {
                            System.out.println("Player " + currentPlayer + " wins!");
                            gameOver = true;
                            break;
                        }
                    }
                    if (gameOver) {
                        break;
                    }
                }


                //Changes player
                currentPlayer = player.changePlayer(currentPlayer);


            }

        }

    }
}