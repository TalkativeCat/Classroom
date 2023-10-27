import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

class DataGroup<T> {
    Reader reader = new Reader();

    public DataGroup(ByFamily byFamily) {
    }
    public DataGroup(ByAge byAge) {
    }

    public DataGroup() {

    }

    @FunctionalInterface
    interface ByFamily {
        String family(Person person);
    }
    @FunctionalInterface
    interface ByAge {
        int age(Person person);
    }
    public HashMap<T, ArrayList<Person>> addPerson(Function<Person, T> classifier) {

        HashMap<T, ArrayList<Person>> sortedMap = new HashMap<>();

        for (Person persons : reader.readCsv()) {
            T key = classifier.apply(persons);
            sortedMap.computeIfAbsent(key, k -> new ArrayList<>()).add(persons);
        }
        return sortedMap;
    }

}
