package new_game;

public class Tictactoe {
    protected char[][] board; // Represents the game board

    public Tictactoe(int size) {
        // Initialize the board with the specified size
        board = new char[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        // Initialize the board with empty spaces or other symbols
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void displayBoard() {
        // Display the current state of the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
