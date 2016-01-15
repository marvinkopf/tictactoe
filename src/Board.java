public class Board {
    private char[] _board = new char[9];

    public Board() {
        clean();
    }

    public void setField(char field, int element) {
        if (!validateField(element))
            throw new RuntimeException();
        _board[element] = field;
    }

    public void clean() {
        for (int i = 0; i < 9; i++)
            _board[i] = 95;
    }

    public void draw() {
        System.out.println("\n\n");
        for (int i = 0; i < 9; i++) {
            System.out.print(_board[i]);
            if ((i + 1) % 3 == 0 && (i + 1) / 3 > 0)
                System.out.print("\n");
        }
    }

    public boolean checkWin() {
        int[][] winningRows = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };

        for (int[] winningRow : winningRows)
            if (_board[winningRow[0]] != '_' &&
                    _board[winningRow[0]] == _board[winningRow[1]] &&
                    _board[winningRow[1]] == _board[winningRow[2]]) {
                return true;
            }
        return false;
    }

    public boolean validateField(int element) {
        return _board[element] == '_';
    }
}
