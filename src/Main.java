import src.struct.Game;
import src.struct.Player;
import src.struct.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Player player1 = new Player("Player 1",'X',board);
        Player player2 = new Player("Player 2",'O',board);
        Game game = new Game(player1,player2);
        game.play();
    }
}
