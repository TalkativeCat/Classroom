package dataLoad;

import dataGroup.Person;

import java.util.List;

public interface DataLoader {
    List<Person> loadDataFromCsv();
}
