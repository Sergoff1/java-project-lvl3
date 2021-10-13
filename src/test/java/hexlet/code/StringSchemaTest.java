package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringSchemaTest {
    @Test
    void schemaTest() {
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
}
