package dataLoad;

import model.Person;

import java.util.List;

public interface DataLoader {
    List<Person> getCashedPersonList();
}
