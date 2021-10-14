package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    private Integer minLength;
    private String contains;
    private boolean isRequired;

    public boolean isValid(Object o) {
        String string = (String) o;
        return checkRequired(string) && checkMinLength(string) && checkContains(string, contains);
    }

    public StringSchema required() {
        isRequired = !isRequired;
        return this;
    }

    public StringSchema contains(String subString) {
        contains = subString;
        return this;
    }

    public StringSchema minLength(int length) {
        minLength = length;
        return this;
    }

    private boolean checkRequired(String string) {
        return !isRequired || (string != null && !string.isEmpty());
    }

    private boolean checkMinLength(String string) {
        return minLength == null || (string != null && string.length() >= minLength);
    }

    private boolean checkContains(String string, String subString) {
        return subString == null || string.contains(subString);
    }
}
