package services;

import old.dataLoad.DataLoader;
import old.model.Person;

import java.util.List;

public class StudentService {

    private List<Person> cachedStudents;
    private DataLoader dataLoader;

    public StudentService(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
        this.cachedStudents = null;
    }

    public List<Person> getStudents() {
        if (cachedStudents == null) {
            cachedStudents = dataLoader.getCashedPersonList();
        }
        return cachedStudents;
    }

}
