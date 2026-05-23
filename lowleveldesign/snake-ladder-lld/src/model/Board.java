package model;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private final int size;
    private final Map<Integer, Jump> jumps = new HashMap<>();

    public Board(int size) {
        this.size = size;
    }

    public void addJump(Jump jump) {
        jumps.put(jump.getStart(), jump);
    }

    public Jump getJump(int position) {
        return jumps.get(position);
    }

    public int getSize() {
        return size;
    }
}