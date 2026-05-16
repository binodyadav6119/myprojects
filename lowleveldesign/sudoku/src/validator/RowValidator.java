package validator;


import model.SudokuBoard;

import java.util.HashSet;
import java.util.Set;

public class RowValidator implements SudokuValidator {

    @Override
    public boolean validate(SudokuBoard board) {

        for (int row = 0; row < 9; row++) {

            if (!isValid(board.getRow(row))) {
                return false;
            }
        }

        return true;
    }

    private boolean isValid(int[] values) {

        Set<Integer> seen = new HashSet<>();

        for (int value : values) {

            if (value == 0) {
                continue;
            }

            if (!seen.add(value)) {
                return false;
            }
        }

        return true;
    }
}
