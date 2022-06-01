package br.com.reflectionstudy.discovery;

import br.com.reflectionstudy.model.Bird;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static br.com.reflectionstudy.utils.UtilsTools.getMethodNames;
import static org.junit.jupiter.api.Assertions.*;

public class DiscoveryMethods {

    @Test
    public void givenClass_whenGetsMethods_thenCorrect() throws ClassNotFoundException {
        Class<?> animalClass = Class.forName("br.com.reflectionstudy.model.Animal");
        Method[] methods = animalClass.getDeclaredMethods();
        List<String> actualMethods = getMethodNames(methods);

        assertEquals(3, actualMethods.size());
        assertTrue(actualMethods.containsAll(Arrays.asList("getName",
                "setName", "getSound")));
    }

    @Test
    public void givenClass_whenGetsAllPublicMethods_thenCorrect() throws ClassNotFoundException {
        Class<?> birdClass = Class.forName("br.com.reflectionstudy.model.Bird");
        Method[] methods = birdClass.getMethods();
        List<String> methodNames = getMethodNames(methods);

        assertTrue(methodNames.containsAll(Arrays
                .asList("equals", "notifyAll", "hashCode",
                        "walks", "eats", "toString")));
    }

    @Test
    public void givenClass_whenGetsOnlyDeclaredMethods_thenCorrect() throws ClassNotFoundException {
        Class<?> birdClass = Class.forName("br.com.reflectionstudy.model.Bird");
        List<String> actualMethodNames
                = getMethodNames(birdClass.getDeclaredMethods());

        List<String> expectedMethodNames = Arrays
                .asList("setWalks", "walks", "getSound", "eats");

        assertEquals(expectedMethodNames.size(), actualMethodNames.size());
        assertTrue(expectedMethodNames.containsAll(actualMethodNames));
        assertTrue(actualMethodNames.containsAll(expectedMethodNames));
    }

    @Test
    public void givenMethodName_whenGetsMethod_thenCorrect() throws Exception {
        Bird bird = new Bird();
        Method walksMethod = bird.getClass().getDeclaredMethod("walks");
        Method setWalksMethod = bird.getClass().getDeclaredMethod("setWalks", boolean.class);

        assertTrue(walksMethod.canAccess(bird));
        assertTrue(setWalksMethod.canAccess(bird));
    }

    @Test
    public void givenMethod_whenInvokes_thenCorrect() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> birdClass = Class.forName("br.com.reflectionstudy.model.Bird");
        Bird bird = (Bird) birdClass.getConstructor().newInstance();
        Method setWalksMethod = birdClass.getDeclaredMethod("setWalks", boolean.class);
        Method walksMethod = birdClass.getDeclaredMethod("walks");
        boolean walks = (boolean) walksMethod.invoke(bird);

        assertFalse(walks);
        assertFalse(bird.walks());

        setWalksMethod.invoke(bird, true);

        boolean walks2 = (boolean) walksMethod.invoke(bird);
        assertTrue(walks2);
        assertTrue(bird.walks());
    }


}
