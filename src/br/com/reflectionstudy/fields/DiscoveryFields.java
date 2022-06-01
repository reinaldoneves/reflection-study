package br.com.reflectionstudy.fields;

import br.com.reflectionstudy.model.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static br.com.reflectionstudy.utils.UtilsTools.getFieldNames;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiscoveryFields {

    @Test
    public void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect() {
        Object person = new Person();
        Field[] fields = person.getClass().getDeclaredFields();

        List<String> actualFieldNames = getFieldNames(fields);

        assertTrue(Arrays.asList("name", "age")
                .containsAll(actualFieldNames));
    }

}
