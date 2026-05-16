package factory;


import validator.*;

import java.util.List;

public class SudokuFactory {

    public static CompositeValidator createValidator() {

        return new CompositeValidator(
                List.of(
                        new RowValidator(),
                        new ColumnValidator(),
                        new SquareValidator()
                )
        );
    }
}
