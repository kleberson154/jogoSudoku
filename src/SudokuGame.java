import java.util.Scanner;

public class SudokuGame {
    private int[][] board;
    private boolean[][] fixed;

    public SudokuGame(int[][] initialBoard) {
        this.board = new int[9][9];
        this.fixed = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.board[i][j] = initialBoard[i][j];
                if (board[i][j] != 0) fixed[i][j] = true;
            }
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (!isComplete()) {
            printBoard();

            System.out.print("Digite linha (0-8): ");
            int row = scanner.nextInt();
            System.out.print("Digite coluna (0-8): ");
            int col = scanner.nextInt();
            System.out.print("Digite valor (1-9): ");
            int value = scanner.nextInt();

            if (fixed[row][col]) {
                System.out.println("Erro: não pode alterar essa célula!");
                continue;
            }

            if (isValid(row, col, value)) {
                board[row][col] = value;
            } else {
                System.out.println("Valor inválido!");
            }
        }

        System.out.println("Parabéns! Você completou o Sudoku!");
        printBoard();
        scanner.close();
    }

    private boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) return false;
        }

        int startRow = (row / 3) * 3, startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) return false;
            }
        }

        return true;
    }

    private boolean isComplete() {
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == 0) return false;
            }
        }
        return true;
    }

    private void printBoard() {
        System.out.println("\nTabuleiro Sudoku:");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) System.out.println("+-------+-------+-------+");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) System.out.print("| ");
                System.out.print((board[i][j] == 0 ? "." : board[i][j]) + " ");
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+");
    }
}
