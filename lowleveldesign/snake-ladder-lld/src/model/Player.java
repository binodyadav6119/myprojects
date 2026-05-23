package model;

import card.Inventory;

public class Player {
    private final String id;
    private final String name;
    private int position;
    private final Inventory inventory;

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
        this.position = 0;
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Inventory getInventory() {
        return inventory;
    }
}