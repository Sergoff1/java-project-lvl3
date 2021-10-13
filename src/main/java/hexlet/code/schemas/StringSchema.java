package hexlet.code.schemas;

public class StringSchema {

    private boolean isRequired;
    private Integer minLength;
    private String contains;

    public boolean isValid(String string) {
        if (isRequired && (string == null || string.isEmpty())) {
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

    public void required() {
        isRequired = !isRequired;
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
