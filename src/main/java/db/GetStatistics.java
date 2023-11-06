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
            System.out.println("Список отличников старше " + age + " лет:");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " + resultSet.getString("family"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConnectionManager.closeConnections();
    }
}
