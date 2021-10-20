package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        this.addRequirement(string -> string instanceof String
                && !((String) string).isBlank());
        return this;
    }

    public StringSchema contains(String subString) {
        addRequirement(string -> string instanceof String && ((String) string).contains(subString));
        return this;
    }

    public StringSchema minLength(int length) {
        addRequirement(string -> string instanceof String && ((String) string).length() >= length);
        return this;
    }
}
