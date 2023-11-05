package db;

import dataGroup.Person;
import dataGroup.StudentService;
import dataLoad.Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Init extends Reader {
    static String url = "jdbc:postgresql://localhost:5432/mydb";
    static String username = "denis";
    static String password = "denis";
    public void initDB() {
        String scriptFilePath = "src/main/java/db/init.sql";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             BufferedReader reader = new BufferedReader(new FileReader(scriptFilePath))) {

            String line;
            StringBuilder script = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                script.append(line);
                if (line.endsWith(";")) {
                    statement.execute(script.toString());
                    script.setLength(0);
                }
            }

            System.out.println("Таблицы успешно созданы");

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addDataToEducationalPlans() {
        Reader reader = new Reader();
        StudentService studentService = new StudentService(reader);
        List<Person> personList = studentService.getStudents();
        List<Integer> groupList = new ArrayList<>();
        for (Person persons : personList) {
            String requestStudents = "INSERT INTO educational_plans (group_name) VALUES (?)";
            try (Connection connection = DriverManager.getConnection(url, username, password);
                 PreparedStatement statement0 = connection.prepareStatement(requestStudents, Statement.RETURN_GENERATED_KEYS)) {
                if (!groupList.contains(persons.getGroup())) {
                    groupList.add(persons.getGroup());
                    statement0.setInt(1, persons.getGroup());

                    int affectedRows = statement0.executeUpdate();
                    if (affectedRows > 0) {
                        System.out.println("Номер группы добавлен: " + persons.getGroup());
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void addDataToDB() {
        int count = 0;

        Reader reader = new Reader();
        StudentService studentService = new StudentService(reader);
        List<Person> personList = studentService.getStudents();

        for (Person persons : personList) {
            String requestStudents = "INSERT INTO students (person_id, name, family, age, group_name) VALUES (?, ?, ?, ?, ?); ";
            count += 1;

            try (Connection connection = DriverManager.getConnection(url, username, password);
                 PreparedStatement statement1 = connection.prepareStatement(requestStudents, Statement.RETURN_GENERATED_KEYS)) {

                statement1.setInt(1, count);
                statement1.setString(2, persons.getName());
                statement1.setString(3, persons.getFamily());
                statement1.setInt(4, persons.getAge());
                statement1.setInt(5, persons.getGroup());

                int affectedRows = statement1.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Ученик добавлен. person_id = " + count);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            String requestStudentGrades = "INSERT INTO student_grades (person_id, physics, mathematics, rus, literature, geometry, informatics) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (Connection connection2 = DriverManager.getConnection(url, username, password);
                 PreparedStatement statement2 = connection2.prepareStatement(requestStudentGrades, Statement.RETURN_GENERATED_KEYS)) {

                statement2.setInt(1, count);
                statement2.setInt(2, persons.getPhysics());
                statement2.setInt(3, persons.getMathematics());
                statement2.setInt(4, persons.getRus());
                statement2.setInt(5, persons.getLiterature());
                statement2.setInt(6, persons.getGeometry());
                statement2.setInt(7, persons.getInformatics());

                int affectedRows = statement2.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Оценки добавлены. person_id = " + count);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
