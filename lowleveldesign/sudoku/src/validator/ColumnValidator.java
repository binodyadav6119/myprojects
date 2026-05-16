package validator;



import model.SudokuBoard;

import java.util.HashSet;
import java.util.Set;

public class ColumnValidator implements SudokuValidator {

    @Override
    public boolean validate(SudokuBoard board) {

        for (int col = 0; col < 9; col++) {

            if (!isValid(board.getColumn(col))) {
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