package dataGroup;

@FunctionalInterface
public interface GroupCriterion<T> {
    T apply(Person person);
}
