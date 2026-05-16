import data.PuzzleData;
import factory.SudokuFactory;
import model.SudokuBoard;
import util.SudokuPrinter;
import validator.CompositeValidator;

public class SudokuMain {

    public static void main(String[] args) {

        SudokuBoard validBoard =
                new SudokuBoard(
                        PuzzleData.VALID_PUZZLE);

        SudokuBoard invalidBoard =
                new SudokuBoard(
                        PuzzleData.INVALID_PUZZLE);

        CompositeValidator validator =
                SudokuFactory.createValidator();

        SudokuPrinter.print(validBoard);

        System.out.println(
                "Valid Board: "
                        + validator.validate(validBoard));

        System.out.println();

        SudokuPrinter.print(invalidBoard);

        System.out.println(
                "Invalid Board: "
                        + validator.validate(invalidBoard));
    }
}