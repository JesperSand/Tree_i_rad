import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        //Creates the initial board
        Board Board = new Board();
        //calls the printBoard method in the board class
        Board.printBoard();

        System.out.println("Vilken ruta vill du välja? (1-9)");

        int number = sc.nextInt();
        int[] position = Board.convertNumberToPosition(number);







    }
}