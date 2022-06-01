package br.com.reflectionstudy.model;

import br.com.reflectionstudy.interfaces.Locomotion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Goat extends Animal implements Locomotion {

    public Goat(String goat) {
        super(goat);
    }

    @Override
    protected String getSound() {
        return "bleat";
    }

    @Override
    public String getLocomotion() {
        return "walks";
    }

    @Override
    public String eats() {
        return "grass";
    }

    // constructor omitted
}