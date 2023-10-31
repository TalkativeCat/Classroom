package dataLoad;

import dataGroup.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader implements DataLoader {

    public List<Person> loadDataFromCsv() {
        ArrayList<Person> personList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                String family = data[0];
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int group = Integer.parseInt(data[3]);
                int physics = Integer.parseInt(data[4]);
                int mathematics = Integer.parseInt(data[5]);
                int rus = Integer.parseInt(data[6]);
                int literature = Integer.parseInt(data[7]);
                int geometry = Integer.parseInt(data[8]);
                int informatics = Integer.parseInt(data[9]);
                Person person = new Person(family, name, age, group, physics, mathematics, rus, literature, geometry, informatics);
                personList.add(person);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return personList;
    }
}
