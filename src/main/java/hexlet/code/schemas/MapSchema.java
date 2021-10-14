package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    private Integer mapSize;
    private Map<String, BaseSchema> shape;
    private boolean isRequired;

    @Override
    public boolean isValid(Object o) {
        Map<Object, Object> map = (Map<Object, Object>) o;
        return checkRequired(o) && checkShape(map) && checkSize(map);
    }

    public MapSchema required() {
        isRequired = !isRequired;
        return this;
    }

    public void sizeof(int size) {
        this.mapSize = size;
    }

    public void shape(Map<String, BaseSchema> map) {
        this.shape = map;
    }

    private boolean checkRequired(Object o) {
        return !isRequired || o instanceof Map;
    }

    private boolean checkSize(Map<Object, Object> map) {
        return mapSize == null || map.size() == mapSize;
    }

    private boolean checkShape(Map<Object, Object> map) {
        if (shape == null) {
            return true;
        }
        for (String key : shape.keySet()) {
            if (map.containsKey(key) && !shape.get(key).isValid(map.get(key))) {
                return false;
            }
        }
        return true;
    }
}
