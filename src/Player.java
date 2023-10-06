public class Player {

    private String Name;

    public Player() {
        this.Name = Name;
    }

    public String changePlayer(String currentPlayer) {
        if (currentPlayer.equals("X")) {
            return "O";
        } else {
            return "X";
        }
    }

}
