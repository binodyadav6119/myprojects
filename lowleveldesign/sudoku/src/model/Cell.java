package model;

public class Cell {

    private final int value;

    public Cell(int value) {

        if (value < 0 || value > 9) {
            throw new IllegalArgumentException(
                    "Cell value must be between 0 and 9");
        }

        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEmpty() {
        return value == 0;
    }
}