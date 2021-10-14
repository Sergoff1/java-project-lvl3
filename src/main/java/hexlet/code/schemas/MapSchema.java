package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    private Integer mapSize;
    private Map<String, BaseSchema> shape;

    @Override
    public boolean isValid(Object o) {
        if (isRequired() && !(o instanceof Map)) {
            return false;
        }

        Map<Object, Object> map = (Map<Object, Object>) o;

        if (mapSize != null && !(map.size() == mapSize)) {
            return false;
        }

        if (shape != null) {
            for (String key : shape.keySet()) {
                if (map.containsKey(key) && !shape.get(key).isValid(map.get(key))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void sizeof(int size) {
        this.mapSize = size;
    }

    public void shape(Map<String, BaseSchema> map) {
        this.shape = map;
    }
}
