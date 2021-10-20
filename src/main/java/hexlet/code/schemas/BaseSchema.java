package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {

    private List<Predicate<Object>> requirements = new ArrayList<>();

    protected final void addRequirement(Predicate<Object> requirement) {
        requirements.add(requirement);
    }

    public final boolean isValid(Object data) {
        for (Predicate<Object> requirement : requirements) {
            if (!requirement.test(data)) {
                return false;
            }
        }
        return true;
    }
}
