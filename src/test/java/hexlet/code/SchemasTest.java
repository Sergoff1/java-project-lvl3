package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SchemasTest {
    @Test
    void stringSchemaTest() {
        StringSchema schema = new Validator().string();

        Assertions.assertTrue(schema.isValid(""));
        Assertions.assertTrue(schema.isValid(null));

        schema.required();

        Assertions.assertTrue(schema.isValid("what does the fox say"));
        Assertions.assertTrue(schema.isValid("hexlet"));
        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertFalse(schema.isValid(""));

        final int minLength = 6;

        Assertions.assertFalse(schema.minLength(minLength).isValid("Hello"));
        Assertions.assertTrue(schema.isValid("Hello World!"));

        Assertions.assertTrue(schema.contains("what").isValid("what does the fox say"));
        Assertions.assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
    }

    @Test
    void numberSchemaTest() {
        NumberSchema schema = new Validator().number();

        Assertions.assertTrue(schema.isValid(null));

        schema.required();

        final int six = 6;
        final int ten = 10;
        final int five = 5;

        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertTrue(schema.isValid(six));
        Assertions.assertFalse(schema.isValid("5"));

        Assertions.assertTrue(schema.positive().isValid(ten));
        Assertions.assertFalse(schema.isValid(-six));

        schema.range(five, ten);

        Assertions.assertTrue(schema.isValid(ten));
        Assertions.assertTrue(schema.isValid(five));
        Assertions.assertFalse(schema.isValid(ten + 1));
        Assertions.assertFalse(schema.isValid(five - 1));
    }

    @Test
    void mapSchemaTest() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Assertions.assertTrue(schema.isValid(null));

        schema.required();

        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertTrue(schema.isValid(new HashMap<>()));

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        Assertions.assertTrue(schema.isValid(data));

        schema.sizeof(2);

        Assertions.assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        Assertions.assertTrue(schema.isValid(data));

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        final int hundred = 100;

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", hundred);
        Assertions.assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        Assertions.assertTrue(schema.isValid(human2));


        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        Assertions.assertFalse(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -hundred);
        Assertions.assertFalse(schema.isValid(human4));
    }
}
