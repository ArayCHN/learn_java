package tictactoe;

public class TicTacToe {
    private int[][] board = new int[3][3];
    TicTacToe() {
        // initilize the board
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = 0;
    }
    int place(int player, int row, int column) {
        if (board[row][column] != 0)
            return 3;
        board[row][column] = player;
        return who_wins();
    }
    int who_wins() {
        // row
        for (int i = 0; i < 3; i++) {
            int current_player = board[i][0];
            boolean wins = true;
            for (int j = 1; j < 3; j++) {
                if (board[i][j] != current_player) {
                    wins = false;
                    break;
                }
            }
            if (wins)
                return current_player;
        }
        // column
        for (int i = 0; i < 3; i++) {
            int current_player = board[0][i];
            boolean wins = true;
            for (int j = 1; j < 3; j++) {
                if (board[j][i] != current_player) {
                    wins = false;
                    break;
                }
            }
            if (wins)
                return current_player;
        }
        // diagnal
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return board[0][0];
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0])
            return board[0][2];
        // no one wins
        return 0;
    }
}