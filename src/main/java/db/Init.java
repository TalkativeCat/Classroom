package db;

import dataGroup.Person;
import dataGroup.StudentService;
import dataLoad.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;


public class Init extends Reader {
    public void initDB() {
        String scriptFilePath = "src/main/java/db/init.sql";

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "denis", "denis");
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

            System.out.println("SQL скрипт выполнен успешно");

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addDataToDB()  {
        String url = "jdbc:postgresql://localhost:5432/mydb";
        String username = "denis";
        String password = "denis";
        int count = 0;

        Reader reader = new Reader();
        StudentService studentService = new StudentService(reader);

        for (Person persons : studentService.getStudents()) {
            String request = "INSERT INTO students (person_id, name, family, age, group_name) VALUES (?, ?, ?, ?, ?)";

            try (Connection connection = DriverManager.getConnection(url, username, password);
                 PreparedStatement statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS)) {

                count += 1;

                statement.setInt(1, count);
                statement.setString(2, persons.getName());
                statement.setString(3, persons.getFamily());
                statement.setInt(4, persons.getAge());
                statement.setInt(5, persons.getGroup());

                int affectedRows = statement.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Запись успешно добавлена. person_id = " + count);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
