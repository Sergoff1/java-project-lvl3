package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

        Assertions.assertFalse(schema.minLength(6).isValid("Hello"));
        Assertions.assertTrue(schema.isValid("Hello World!"));

        Assertions.assertTrue(schema.contains("what").isValid("what does the fox say"));
        Assertions.assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
    }

    @Test
    void numberSchemaTest() {
        NumberSchema schema = new Validator().number();

        Assertions.assertTrue(schema.isValid(null));

        schema.required();

        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertTrue(schema.isValid(6));
        Assertions.assertFalse(schema.isValid("5"));

        Assertions.assertTrue(schema.positive().isValid(10));
        Assertions.assertFalse(schema.isValid(-6));

        schema.range(5, 10);

        Assertions.assertTrue(schema.isValid(10));
        Assertions.assertTrue(schema.isValid(5));
        Assertions.assertFalse(schema.isValid(11));
        Assertions.assertFalse(schema.isValid(4));
    }
}
