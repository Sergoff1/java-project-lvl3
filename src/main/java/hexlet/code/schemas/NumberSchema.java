package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    private boolean isPositive;
    private Integer startRange;
    private Integer endRange;
    private boolean isRequired;

    @Override
    public boolean isValid(Object o) {
        if (!checkRequired(o)) {
            return false;
        }
        Integer num = (Integer) o;
        return checkIsPositive(num) && checkRange(num);
    }

    public NumberSchema required() {
        isRequired = !isRequired;
        return this;
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

    private boolean checkRequired(Object o) {
        return !isRequired || o instanceof Integer;
    }

    private boolean checkIsPositive(Integer num) {
        if (isPositive && num == null) {
            return true;
        }
        return !isPositive || num > 0;
    }

    private boolean checkRange(Integer num) {
        if (startRange == null) {
            return true;
        }
        return num != null && (startRange <= num && endRange >= num);
    }
}
