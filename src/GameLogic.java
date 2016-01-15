import java.util.ArrayList;
import java.util.Scanner;

public class GameLogic {
    ArrayList<Player> _players = new ArrayList<>();
    Player _activePlayer;
    Board _board = new Board();

    public void start() {

        while (true) {
            char mode = ' ';
            while (mode != '1' && mode != '2') {
                System.out.println("New game\n 1: Player vs Player\n 2: Player cs Computer\n");

                Scanner s = new Scanner(System.in);
                mode = s.next().charAt(0);
            }

            _players.add(new Human("Player 1"));

            if (mode == '1') {
                _players.add(new Human("Player 2"));
                _activePlayer = _players.get(0);
            } else {
                _players.add(new Computer());

                char first = ' ';

                while (first != 'y' && first != 'n') {
                    System.out.println("\nStart first? (y/n):");
                    Scanner s = new Scanner(System.in);
                    first = s.next().charAt(0);
                }

                if (first == 'y')
                    _activePlayer = _players.get(0);
                else
                    _activePlayer = _players.get(1);
            }

            _activePlayer.setMove('X');

            play();
            _board.clean();
            _players.clear();
        }
    }

    void play() {
        _board.draw();
        for (int i = 0; i < 9; i++) {
            _activePlayer.move(_board);
            _board.draw();

            if (_board.checkWin()) {
                System.out.println(_activePlayer._name + " has won the game!");
                return;
            }

            _activePlayer =
                    _activePlayer == _players.get(0) ?
                            _players.get(1) : _players.get(0);
        }

        System.out.println("Draw! ");
    }
}
