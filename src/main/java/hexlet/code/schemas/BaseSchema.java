package hexlet.code.schemas;

public class BaseSchema {

    protected boolean isRequired;

    public boolean isValid(Object o) {
        return true;
    }

    public void required() {
        isRequired = !isRequired;
    }
}
