package main.java.com.mikitarudy.simulation.entity;

public abstract class Entity {
    private final String emoji;

    public Entity(String emoji) {
        this.emoji = emoji;
    }

    @Override
    public String toString() {
        return emoji;
    }
}
