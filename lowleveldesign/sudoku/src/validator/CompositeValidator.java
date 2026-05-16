package validator;


import model.SudokuBoard;

import java.util.List;

public class CompositeValidator implements SudokuValidator {

    private final List<SudokuValidator> validators;

    public CompositeValidator(List<SudokuValidator> validators) {
        this.validators = validators;
    }

    @Override
    public boolean validate(SudokuBoard board) {

        for (SudokuValidator validator : validators) {

            if (!validator.validate(board)) {
                return false;
            }
        }

        return true;
    }
}