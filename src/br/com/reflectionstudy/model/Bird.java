package br.com.reflectionstudy.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bird extends Animal {
    private boolean walks;

    public Bird() {
        super("bird");
    }

    public Bird(String name, boolean walks) {
        super(name);
        setWalks(walks);
    }

    public Bird(String name) {
        super(name);
    }

    public boolean walks() {
        return walks;
    }

    @Override
    public String eats() {
        return "worms";
    }

    @Override
    protected String getSound() {
        return null;
    }

    // standard setters and overridden methods
}
