package br.com.reflectionstudy.discovery;

import br.com.reflectionstudy.model.Goat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/***
 * Discovering the names of classes at run time.
 */
public class DiscoveryClassNames {

    /**
     * Given an Object, we can discover its class name.
     */
    @Test
    public void givenObject_whenGetsClassName_thenCorrect() {
        Object goat = new Goat("goat");
        Class<?> clazz = goat.getClass();

        assertEquals("Goat", clazz.getSimpleName());
        assertEquals("br.com.reflectionstudy.model.Goat", clazz.getName());
        assertEquals("br.com.reflectionstudy.model.Goat", clazz.getCanonicalName());
    }

    /***
     * Given a class, we can create objects of that class.
     * @throws ClassNotFoundException
     */
    @Test
    public void givenClassName_whenCreatesObject_thenCorrect() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("br.com.reflectionstudy.model.Goat");
        Goat goat = new Goat("goat");

        assertEquals(goat.getClass().getSimpleName(), clazz.getSimpleName());
        assertEquals("br.com.reflectionstudy.model.Goat", clazz.getName());
        assertEquals("br.com.reflectionstudy.model.Goat", clazz.getCanonicalName());
    }

}
