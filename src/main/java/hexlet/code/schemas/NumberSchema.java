package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addRequirement(num -> num instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addRequirement(num -> num == null || num instanceof Integer && (Integer) num > 0);
        return this;
    }

    public NumberSchema range(int start, int end) {
        addRequirement(num -> num instanceof Integer && (Integer) num >= start && (Integer) num <= end);
        return this;
    }
}
