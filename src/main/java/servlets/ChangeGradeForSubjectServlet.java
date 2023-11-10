package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dataLoad.Reader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.commands.ChangeGradeForSubject;
import servlets.requestModel.RequestChangeGradeForSubject;
import servlets.responseModel.ResponseChangeGradeForSubject;

import java.io.IOException;

@WebServlet(urlPatterns = {"/changeGradeForSubject"})
public class ChangeGradeForSubjectServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var mapper = new ObjectMapper();
        RequestChangeGradeForSubject requestPerson = null;
        try (var input = req.getInputStream()) {
            requestPerson = mapper.readValue(new String(input.readAllBytes()), RequestChangeGradeForSubject.class);
        }
        ChangeGradeForSubject changeGradeForSubject = new ChangeGradeForSubject();
        ResponseChangeGradeForSubject responseChangeGradeForSubject = changeGradeForSubject.changeGrade(requestPerson);
        if (responseChangeGradeForSubject.getNewGrade() != 0) {
            responseChangeGradeForSubject.setSubject(requestPerson.getSubject());
            responseChangeGradeForSubject.setStatus("Grade has been successfully changed");
            try (var output = resp.getWriter()) {
                resp.setContentType("application/json; charset=UTF-8");
                output.write(mapper.writeValueAsString(responseChangeGradeForSubject));
                output.flush();
            }
        }
        else {
            try (var output = resp.getWriter()) {
                responseChangeGradeForSubject.setStatus("Error occurred, student was not found");
                resp.setContentType("application/json; charset=UTF-8");
                output.write(mapper.writeValueAsString(responseChangeGradeForSubject.getStatus()));
                output.flush();
            }
        }

    }
}
