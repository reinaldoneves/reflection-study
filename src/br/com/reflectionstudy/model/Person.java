package br.com.reflectionstudy.model;

import br.com.reflectionstudy.interfaces.Eating;
import br.com.reflectionstudy.interfaces.Locomotion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Eating, Locomotion {

    private String name;
    private int age;

    @Override
    public String eats() {
        return "All kinds of crap provided by agribusiness";
    }

    @Override
    public String getLocomotion() {
        return "walks";
    }
}
