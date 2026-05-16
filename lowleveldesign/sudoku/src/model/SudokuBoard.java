package model;

public class SudokuBoard {

    private final Cell[][] board;

    public SudokuBoard(int[] values) {

        if (values.length != 81) {
            throw new IllegalArgumentException(
                    "Sudoku requires exactly 81 numbers");
        }

        board = new Cell[9][9];

        int index = 0;

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                board[row][col] = new Cell(values[index++]);
            }
        }
    }

    public int getValue(int row, int col) {
        return board[row][col].getValue();
    }

    public int[] getRow(int row) {

        int[] result = new int[9];

        for (int col = 0; col < 9; col++) {
            result[col] = getValue(row, col);
        }

        return result;
    }

    public int[] getColumn(int col) {

        int[] result = new int[9];

        for (int row = 0; row < 9; row++) {
            result[row] = getValue(row, col);
        }

        return result;
    }

    public int[] getSquare(int squareIndex) {

        int[] result = new int[9];

        int startRow = (squareIndex / 3) * 3;
        int startCol = (squareIndex % 3) * 3;

        int index = 0;

        for (int row = startRow; row < startRow + 3; row++) {

            for (int col = startCol; col < startCol + 3; col++) {

                result[index++] = getValue(row, col);
            }
        }

        return result;
    }
}