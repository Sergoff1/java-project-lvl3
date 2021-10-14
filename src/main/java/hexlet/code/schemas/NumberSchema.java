package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    private boolean isPositive;
    private Integer startRange;
    private Integer endRange;

    @Override
    public boolean isValid(Object o) {
        if (isRequired() && !(o instanceof Integer)) {
            return false;
        }

        Integer num = (Integer) o;
        if (isPositive && num != null && num <= 0) {
            return false;
        }
        if (startRange != null && num != null && !(startRange <= num && endRange >= num)) {
            return false;
        }

        return true;
    }

    public NumberSchema positive() {
        isPositive = !isPositive;
        return this;
    }

    public NumberSchema range(int start, int end) {
        startRange = start;
        endRange = end;
        return this;
    }
}
