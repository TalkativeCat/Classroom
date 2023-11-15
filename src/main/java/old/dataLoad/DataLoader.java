package old.dataLoad;

import old.model.Person;

import java.util.List;

public interface DataLoader {
    List<Person> getCashedPersonList();
}
