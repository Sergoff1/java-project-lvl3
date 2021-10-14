package hexlet.code.schemas;

public abstract class BaseSchema {

    private boolean required;

    public abstract boolean isValid(Object o);

    public final BaseSchema required() {
        required = !required;
        return this;
    }

    public final boolean isRequired() {
        return required;
    }
}
