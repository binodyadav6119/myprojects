package util;



import model.SudokuBoard;

public class SudokuPrinter {

    public static void print(SudokuBoard board) {

        for (int row = 0; row < 9; row++) {

            if (row % 3 == 0) {
                System.out.println(
                        "-------------------------");
            }

            for (int col = 0; col < 9; col++) {

                if (col % 3 == 0) {
                    System.out.print("| ");
                }

                System.out.print(
                        board.getValue(row, col) + " ");
            }

            System.out.println("|");
        }

        System.out.println(
                "-------------------------");
    }
}
