package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema required() {
        addRequirement(map -> map instanceof Map);
        return this;
    }

    public MapSchema sizeof(int size) {
        addRequirement(map -> map instanceof Map && ((Map<?, ?>) map).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addRequirement(map -> map == null || map instanceof Map && schemas.entrySet().stream()
                .allMatch(schema -> schema.getValue().isValid(((Map<?, ?>) map).get(schema.getKey()))));

        return this;
    }
}
