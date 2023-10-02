public class Board {
    private String[][] gameBoard;

    //constructor for initializing the board...
    public Board() {
        gameBoard = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = " ";
            }
        }
    }

    // methods to manipulate and get information about the board...
    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + gameBoard[i][j] + " ");
                // Prints out a verical line if not the last collumn
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            //Prints out a horizontal line if not the last row
            if (i < 2) {
                System.out.println("----------------");
            }
        }
    }

    public void placeMarker(int row, int col, String marker) {
        // Check if user input is inside the board
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            //Check if square is empty
            if (gameBoard[row][col].equals(" ")) {
                //If empty, place marker
                gameBoard[row][col] = marker;
            }
            //If taken, print out an error
            else {
                System.out.println("Denna ruta är redan tagen!");
            }
        }
        //If outside the board, print out error
        else {
            System.out.println("Ogiltig rad eller kolumn!");
        }
    }

    public int[] convertNumberToPosition(int number) {
        int row = (number - 1) / 3;
        int col = (number - 1) % 3;
        return new int[]{row, col};
    }
}