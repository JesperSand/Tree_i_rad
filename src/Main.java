import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String currentPlayer = "X";
        // Om spelet är över, sätt gameOver = true
        boolean gameOver = false;

        //Creates the initial board
        Board Board = new Board();
        Player Player = new Player();

        while (!gameOver) {
            //calls the printBoard method in the board class
            Board.printBoard();
            System.out.println("Current player: " + currentPlayer);
            System.out.println("Enter row and column:");
            // Använd Scanner för att ta emot input från spelaren
            // och uppdatera spelbrädet med spelarens valda markör
            int number = sc.nextInt();
            int[] position = Board.convertNumberToPosition(number);
            Board.placeMarker(position[0], position[1], currentPlayer);
            // Byt nuvarande spelare
            currentPlayer = Player.changePlayer(currentPlayer);




        }

    }



}