package servlets;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.GetStatisticsService;
import services.interfaces.StudentGradesRepository;
import services.interfaces.StudentsRepository;
import servlets.requestModel.RequestChangeGradeForSubject;
import servlets.responseModel.ResponseAverageStudentGradeByClass;
import servlets.responseModel.ResponseChangeGradeForSubject;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class StudentsApi {
    public final StudentsRepository studentsRepository;
    public final StudentGradesRepository studentGradesRepository;

    @PostMapping("changeGradeForSubject")
    public SimpleResponse<ResponseChangeGradeForSubject> changeGradeForSubject(@RequestBody RequestChangeGradeForSubject req) {
        GetStatisticsService getStatisticsService = new GetStatisticsService(studentsRepository, studentGradesRepository);
        var result = getStatisticsService.changeGrade(req);
        return new SimpleResponse<>(result);
    }

    @GetMapping("averageStudentGradeByClass")
    public SimpleResponse<List<ResponseAverageStudentGradeByClass>> averageStudentGradeByClass(@RequestParam("group") int group) {
        GetStatisticsService getStatisticsService = new GetStatisticsService(studentsRepository, studentGradesRepository);
        var result = getStatisticsService.getAverageStudentGrade(group);
        return new SimpleResponse<>(result);
    }

}
