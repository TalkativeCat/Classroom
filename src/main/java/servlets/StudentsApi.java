package servlets;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.GetStatisticsService;
import services.interfaces.StudentGradesRepository;
import services.interfaces.StudentsRepository;
import servlets.requestModel.RequestAverageStudentGradeByClass;
import servlets.requestModel.RequestChangeGradeForSubject;
import servlets.responseModel.ResponseAverageStudentGradeByClass;
import servlets.responseModel.ResponseChangeGradeForSubject;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class StudentsApi {
    private final StudentsRepository studentsRepository;
    private final StudentGradesRepository studentGradesRepository;

    @PostMapping("changeGradeForSubject")
    public @ResponseBody SimpleResponse<ResponseChangeGradeForSubject> changeGradeForSubject(@RequestBody RequestChangeGradeForSubject req) {
        GetStatisticsService getStatisticsService = new GetStatisticsService(studentsRepository, studentGradesRepository);
        var result = getStatisticsService.changeGrade(req);
        return new SimpleResponse<>(result);
    }

    @PostMapping("averageStudentGradeByClass")
    public SimpleResponse <List<ResponseAverageStudentGradeByClass>> averageStudentGradeByClass(@RequestBody RequestAverageStudentGradeByClass group) {
        GetStatisticsService getStatisticsService = new GetStatisticsService(studentsRepository, studentGradesRepository);
        var result = getStatisticsService.getAverageStudentGrade(group.getGroup());
        return new SimpleResponse<>(result);
    }



//    @PostMapping("/changeGradeForSubject2")
//    public ResponseEntity<ResponseChangeGradeForSubject> changeGradeForSubject2(@RequestBody RequestChangeGradeForSubject request) {
//        ChangeGradeForSubject changeGradeForSubject = new ChangeGradeForSubject();
//        ResponseChangeGradeForSubject response = changeGradeForSubject.changeGrade(request);
//
//        if (response.getNewGrade() != 0) {
//            response.setSubject(request.getSubject());
//            response.setStatus("Grade has been successfully changed");
//            return ResponseEntity.ok(response);
//        } else {
//            response.setStatus("Error occurred, student was not found");
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//        }
//    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        var mapper = new ObjectMapper();
//        RequestChangeGradeForSubject requestPerson = null;
//        try (var input = req.getInputStream()) {
//            requestPerson = mapper.readValue(new String(input.readAllBytes()), RequestChangeGradeForSubject.class);
//        }
//        ChangeGradeForSubject changeGradeForSubject = new ChangeGradeForSubject();
//        ResponseChangeGradeForSubject responseChangeGradeForSubject = changeGradeForSubject.changeGrade(requestPerson);
//        if (responseChangeGradeForSubject.getNewGrade() != 0) {
//            responseChangeGradeForSubject.setSubject(requestPerson.getSubject());
//            responseChangeGradeForSubject.setStatus("Grade has been successfully changed");
//            try (var output = resp.getWriter()) {
//                resp.setContentType("application/json; charset=UTF-8");
//                output.write(mapper.writeValueAsString(responseChangeGradeForSubject));
//                output.flush();
//            }
//        }
//        else {
//            try (var output = resp.getWriter()) {
//                responseChangeGradeForSubject.setStatus("Error occurred, student was not found");
//                resp.setContentType("application/json; charset=UTF-8");
//                output.write(mapper.writeValueAsString(responseChangeGradeForSubject.getStatus()));
//                output.flush();
//            }
//        }
////
//    }
}
