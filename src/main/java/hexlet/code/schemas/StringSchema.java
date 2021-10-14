package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    private Integer minLength;
    private String contains;

    public boolean isValid(Object o) {
        String string = (String) o;
        if (isRequired() && (o == null || string.isEmpty())) {
            return false;
        }
        if (minLength != null && string.length() < minLength) {
            return false;
        }
        if (contains != null && !string.contains(contains)) {
            return false;
        }
        return true;
    }

    public StringSchema contains(String subString) {
        contains = subString;
        return this;
    }

    public StringSchema minLength(int length) {
        minLength = length;
        return this;
    }
}
