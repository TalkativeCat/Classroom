package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetStatistics {
    public void getGoodStudentsOlderAge(int age){
        ConnectionManager.connectDB();
        String request = "SELECT s.name, s.family FROM students s JOIN student_grades g ON s.person_id = g.person_id where s.age > " + age + " and (g.physics + g.mathematics + g.rus + g.literature + g.geometry + g.informatics)/6 = 5;";
        try(PreparedStatement statement = ConnectionManager.getConnectDB().prepareStatement(request)){
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Список отличников старше " + age + " лет:\n");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " + resultSet.getString("family"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConnectionManager.closeConnections();
    }
    public void getAverageGrades(int group1, int group2){
        ConnectionManager.connectDB();
        String request = "SELECT ROUND(AVG(grade), 2) AS avg_grade FROM ( SELECT physics AS grade, person_id FROM student_grades UNION ALL SELECT mathematics AS grade, person_id FROM student_grades UNION ALL SELECT rus AS grade, person_id FROM student_grades UNION ALL SELECT literature AS grade, person_id FROM student_grades UNION ALL SELECT geometry AS grade, person_id FROM student_grades UNION ALL SELECT informatics AS grade, person_id FROM student_grades ) AS grades INNER JOIN students ON grades.person_id = students.person_id WHERE students.group_name IN (" + group1 + ", " + group2 + ") AND grades.grade IS NOT NULL";
        try(PreparedStatement statement = ConnectionManager.getConnectDB().prepareStatement(request)){
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            System.out.print("Средняя оценка: ");
            if (resultSet.next()) {
                System.out.println(resultSet.getString("avg_grade"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConnectionManager.closeConnections();
    }
    public void getAverageStudentGrade(String family){
        ConnectionManager.connectDB();
        String request = "SELECT students.name, students.family, students.group_name, (physics + mathematics + rus + literature + geometry + informatics) / 6 AS average_grade FROM students JOIN student_grades ON students.person_id = student_grades.person_id WHERE students.family = '" + family + "'";
        try(PreparedStatement statement = ConnectionManager.getConnectDB().prepareStatement(request)){
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Средняя оценка учеников с фамилией " + family + ":\n");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " + resultSet.getString("family") + ", " + resultSet.getString("group_name") + " класс, средняя оценка: " + resultSet.getString("average_grade"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConnectionManager.closeConnections();
    }
}
