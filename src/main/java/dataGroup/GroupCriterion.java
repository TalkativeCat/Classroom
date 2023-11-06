package dataGroup;

import model.Person;

@FunctionalInterface
public interface GroupCriterion<T> {
    T apply(Person person);
}
