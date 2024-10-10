package com.freund.tabletop_assistant.model;

import java.util.ArrayList;

public class Player {
    private Long id;
    private String name;
    private int hp;
    private GameClass gameClass;
    private ArrayList<String> inventory;

    public Player(Long id, String name, int hp, GameClass gameClass) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.gameClass = gameClass;
        this.inventory = new ArrayList<String>();
    }

    public Player(){
        this.inventory = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public GameClass getGameClass(){
        return this.gameClass;
    }

    public void setGameClass(GameClass gameClass){
        this.gameClass = gameClass;
    }

    public ArrayList<String> getInventory(){
        return this.inventory;
    }

    public void addItem(String item){
        this.inventory.add(item);
    }

    public void removeItem(int itemIndex){
        this.inventory.remove(itemIndex);
    }
}
