import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

class DataGroup<T> {
    Reader reader = new Reader();

    public Person[] addPerson(Function<Person, T> classifier, T variable) {

        HashMap<T, ArrayList<Person>> sortedMap = new HashMap<>();

        for (Person persons : reader.readCsv()) {
            T key = classifier.apply(persons);
            sortedMap.computeIfAbsent(key, k -> new ArrayList<>()).add(persons);
        }
        return sortedMap.get(variable).toArray(new Person[0]);
    }
}
