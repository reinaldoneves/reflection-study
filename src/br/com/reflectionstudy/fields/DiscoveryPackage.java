package br.com.reflectionstudy.fields;

import br.com.reflectionstudy.model.Goat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscoveryPackage {

    @Test
    public void givenClass_whenGetsPackageInfo_thenCorrect() {
        Goat goat = new Goat("goat");
        Class<?> goatClass = goat.getClass();
        Package pkg = goatClass.getPackage();

        assertEquals("br.com.reflectionstudy.model", pkg.getName());
    }

}
