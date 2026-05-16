package validator;


import model.SudokuBoard;

public interface SudokuValidator {

    boolean validate(SudokuBoard board);
}