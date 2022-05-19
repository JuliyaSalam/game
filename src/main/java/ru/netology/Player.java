package ru.netology;

import java.util.Objects;

public class Player{
    private int id;
    private int strength;
    private String name;

    public Player() {
    }

    public Player(int id, int strength, String name) {
        this.id = id;
        this.strength = strength;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  /*  @Override
    public int compareTo(Player o) {
        return this.strength - o.strength;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && strength == player.strength && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, strength, name);
    }
}
