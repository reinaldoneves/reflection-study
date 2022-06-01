package br.com.reflectionstudy.discovery;

import br.com.reflectionstudy.model.Goat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscoveryClassNames {

    @Test
    public void givenObject_whenGetsClassName_thenCorrect() {
        Object goat = new Goat("goat");
        Class<?> clazz = goat.getClass();

        assertEquals("Goat", clazz.getSimpleName());
        assertEquals("br.com.reflectionstudy.model.Goat", clazz.getName());
        assertEquals("br.com.reflectionstudy.model.Goat", clazz.getCanonicalName());
    }

    @Test
    public void givenClassName_whenCreatesObject_thenCorrect() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("br.com.reflectionstudy.model.Goat");

        assertEquals("Goat", clazz.getSimpleName());
        assertEquals("br.com.reflectionstudy.model.Goat", clazz.getName());
        assertEquals("br.com.reflectionstudy.model.Goat", clazz.getCanonicalName());
    }

}
