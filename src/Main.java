public class Main {
    public static void main(String[] args) {
        int[][] puzzle = SudokuGenerator.generateEasyPuzzle();
        SudokuGame game = new SudokuGame(puzzle);
        game.play();
    }
}