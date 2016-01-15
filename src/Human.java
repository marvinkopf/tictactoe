import java.io.IOException;

public class Human extends Player {
    public Human(String name) {
        super(name);
    }

    public void move(Board board) {
        System.out.println("Choose number 1-9:");
        char moveTo;
        while (true) {
            moveTo = ' ';
            while (!((moveTo >= 49) && (moveTo <= 57))) {
                try {
                    moveTo = (char) System.in.read();
                } catch (IOException e) {
                    continue;
                }
            }
            if (board.validateField(moveTo - 49))
                break;
        }
        board.setField(_move, moveTo - 49);
    }
}
