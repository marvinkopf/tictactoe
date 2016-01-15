abstract class Player {
    protected char _move = '0';
    String _name;

    public Player(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public char getMove() {
        return _move;
    }

    public void setMove(char move) {
        this._move = move;
    }

    abstract public void move(Board board);
}
