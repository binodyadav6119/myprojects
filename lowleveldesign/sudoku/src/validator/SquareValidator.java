package validator;



import model.SudokuBoard;

import java.util.HashSet;
import java.util.Set;

public class SquareValidator implements SudokuValidator {

    @Override
    public boolean validate(SudokuBoard board) {

        for (int square = 0; square < 9; square++) {

            if (!isValid(board.getSquare(square))) {
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