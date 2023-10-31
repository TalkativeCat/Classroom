package dataGroup;

import dataLoad.DataLoader;

import java.util.List;

public class StudentService {

    public DataLoader dataLoader;
    public StudentService(DataLoader dataLoader) {

        this.dataLoader = dataLoader;
    }
    public List<Person> getStudents() {

        return dataLoader.loadDataFromCsv();
    }

}
