package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    private Integer mapSize;

    @Override
    public boolean isValid(Object o) {
        if (isRequired && !(o instanceof Map)) {
            return false;
        }

        Map<Object, Object> map = (Map) o;

        if (mapSize != null && !(map.size() == mapSize)) {
            return false;
        }

        return true;
    }

    public void sizeof(int size) {
        this.mapSize = size;
    }
}
