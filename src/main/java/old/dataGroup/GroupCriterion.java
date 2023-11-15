package old.dataGroup;

import old.model.Person;

@FunctionalInterface
public interface GroupCriterion<T> {
    T apply(Person person);
}
