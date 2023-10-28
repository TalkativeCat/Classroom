import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

class DataGroup<T> {
    Reader reader = new Reader();

    private final HashMap<T, ArrayList<Person>> sortedMap = new HashMap<>();

    public void addPerson(Function<Person, T> classifier) {

        for (Person persons : reader.readCsv()) {
            T key = classifier.apply(persons);
            sortedMap.computeIfAbsent(key, k -> new ArrayList<>()).add(persons);
        }
    }
    public Person[] getPersons(Function<Person, T> classifier, T variable) {
        if (sortedMap.isEmpty()) {
            addPerson(classifier);
        }
        return sortedMap.get(variable).toArray(new Person[0]);
    }
}
