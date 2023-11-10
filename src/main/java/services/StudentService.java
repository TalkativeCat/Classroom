package services;

import dataLoad.DataLoader;
import model.Person;

import java.util.List;
import java.util.function.Function;

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
