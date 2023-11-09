package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.PersonAwerageGrade;
import servlets.commands.AverageStudentGradeByClass;
import servlets.commands.RequestPerson;

import java.io.IOException;

@WebServlet(urlPatterns = {"/averageStudentGradeByClass"})
public class AverageStudentGradeByClassServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var mapper = new ObjectMapper();
        RequestPerson requestPerson = null;
        try (var input = request.getInputStream()) {
            requestPerson = mapper.readValue(new String(input.readAllBytes()), RequestPerson.class);
        }
        AverageStudentGradeByClass studentGrades = new AverageStudentGradeByClass();

        PersonAwerageGrade[] grades = studentGrades.getGrades(requestPerson.getGroup());

        try (var output = response.getWriter()) {
            response.setContentType("application/json; charset=UTF-8");
            output.write(mapper.writeValueAsString(grades));
            output.flush();
        }

    }

}
