package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetStatistics {
//    public void getGoodStudentsOlderAge(int age){
//        ConnectionManager.connectDB();
//        String request = "SELECT s.name, s.family FROM t_students s JOIN t_student_grades g ON s.id = g.id where s.age > " + age + " and (g.physics + g.mathematics + g.rus + g.literature + g.geometry + g.informatics)/6 = 5;";
//        try(PreparedStatement statement = ConnectionManager.getConnectDB().prepareStatement(request)){
//            statement.execute();
//            ResultSet resultSet = statement.executeQuery();
//            System.out.println("Список отличников старше " + age + " лет:\n");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("name") + " " + resultSet.getString("family"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        ConnectionManager.closeConnections();
//    }
//    public void getAverageGrades(int group1, int group2){
//        ConnectionManager.connectDB();
//        String request = "SELECT ROUND(AVG(grade), 2) AS avg_grade FROM ( SELECT physics AS grade, id FROM t_student_grades UNION ALL SELECT mathematics AS grade, person_id FROM t_student_grades UNION ALL SELECT rus AS grade, id FROM t_student_grades UNION ALL SELECT literature AS grade, person_id FROM t_student_grades UNION ALL SELECT geometry AS grade, id FROM t_student_grades UNION ALL SELECT informatics AS grade, id FROM t_student_grades ) AS grades INNER JOIN t_students ON grades.id = t_students.id WHERE t_students.group_name IN (" + group1 + ", " + group2 + ") AND grades.grade IS NOT NULL";
//        try(PreparedStatement statement = ConnectionManager.getConnectDB().prepareStatement(request)){
//            statement.execute();
//            ResultSet resultSet = statement.executeQuery();
//            System.out.print("Средняя оценка: ");
//            if (resultSet.next()) {
//                System.out.println(resultSet.getString("avg_grade"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        ConnectionManager.closeConnections();
//    }
//    public void getAverageStudentGrade(String family){
//        ConnectionManager.connectDB();
//        String request = "SELECT t_students.name, t_students.family, t_students.group_name, (physics + mathematics + rus + literature + geometry + informatics) / 6 AS average_grade FROM t_students JOIN t_student_grades ON t_students.id = t_student_grades.id WHERE t_students.family = '" + family + "'";
//        try(PreparedStatement statement = ConnectionManager.getConnectDB().prepareStatement(request)){
//            statement.execute();
//            ResultSet resultSet = statement.executeQuery();
//            System.out.println("Средняя оценка учеников с фамилией " + family + ":\n");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("name") + " " + resultSet.getString("family") + ", " + resultSet.getString("group_name") + " класс, средняя оценка: " + resultSet.getString("average_grade"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        ConnectionManager.closeConnections();
//    }
}
