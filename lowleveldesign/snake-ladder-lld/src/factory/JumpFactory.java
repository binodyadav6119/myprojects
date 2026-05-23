package factory;

import model.Jump;
import model.Ladder;
import model.Snake;

public class JumpFactory {

    public static Jump createJump(String type, int start, int end) {

        if ("SNAKE".equals(type)) {
            return new Snake(start, end);
        }

        if ("LADDER".equals(type)) {
            return new Ladder(start, end);
        }

        throw new IllegalArgumentException("Invalid type");
    }
}