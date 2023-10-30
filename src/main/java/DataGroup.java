import java.util.ArrayList;
import java.util.HashMap;

class DataGroup<T> {
    Reader reader = new Reader();

    private final HashMap<T, ArrayList<Person>> sortedMap = new HashMap<>();

    public void addPerson(GroupCriterion<T> classifier) {

        for (Person persons : reader.readCsv()) {
            T key = classifier.apply(persons);
            sortedMap.computeIfAbsent(key, k -> new ArrayList<>()).add(persons);
        }
    }
    public Person[] getPersons(GroupCriterion<T> classifier, T variable) {
        if (sortedMap.isEmpty()) {
            addPerson(classifier);
        }
        return sortedMap.get(variable).toArray(new Person[0]);
    }
}
