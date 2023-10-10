public class Board {
    private String[][] gameBoard;
    private boolean gameOver = false;
    private String currentPlayer;

    //constructor for initializing the board...
    public Board() {
        gameBoard = new String[3][3];
        currentPlayer = "X";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = " ";
            }
        }
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String player) {
        currentPlayer = player;
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

    int markerCount = 0;
    //Method to place the marker in the chosen square
    public void placeMarker(int row, int col, String marker) {
        // Check if user input is inside the board
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            //Check if square is empty
            if (gameBoard[row][col].equals(" ")) {
                //If empty, place marker
                gameBoard[row][col] = marker;
                //For the game to end a draw
                markerCount++;
                if (markerCount == 9){
                    System.out.println("Oj det blev oavgjort!");
                }
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
    //Converts the users input into a position on the board
    public int[] convertNumberToPosition(int number) {
        int row = (number - 1) / 3;
        int col = (number - 1) % 3;
        return new int[]{row, col};
    }

    public String[][] getGameBoard() {
        return gameBoard;
    }
    //Method to check for possible win
    public boolean checkForWin(){
        //Checks horizontal wins
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i][0].equals(gameBoard[i][1]) && gameBoard[i][0].equals(gameBoard[i][2]) && !gameBoard[i][0].equals(" ")) {
                return true;
            }
        }

        //Checks vertical wins
        for (int i = 0; i < gameBoard[0].length; i++) {
            if (gameBoard[0][i].equals(gameBoard[1][i]) && gameBoard[0][i].equals(gameBoard[2][i]) && !gameBoard[0][i].equals(" ")) {
                return true;
            }
        }

        //Checks diagonal wins
        if (gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[0][0].equals(gameBoard[2][2]) && !gameBoard[0][0].equals(" ")) {
            return true;
        }
        if (gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[0][2].equals(gameBoard[2][0]) && !gameBoard[0][2].equals(" ")) {
            return true;
        }

        //If no win is found return false and the game continues
        return false;
    }
    //Method for changing player
    public void changePlayer() {
        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
    }
}