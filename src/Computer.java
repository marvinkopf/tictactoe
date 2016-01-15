public class Computer extends Player {
    public Computer() {
        super("The Computer");
    }

    public void move(Board board) {
        for (int i = 0; i < 9; i++)
            if (board.validateField(i)) {
                board.setField(_move, i);
                return;
            }
    }
}
