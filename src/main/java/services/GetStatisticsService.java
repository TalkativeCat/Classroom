package services;

import db.model.StudentGrades;
import db.model.Students;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import services.interfaces.StudentGradesRepository;
import services.interfaces.StudentsRepository;
import servlets.responseModel.ResponseAverageStudentGradeByClass;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Validated
@RequiredArgsConstructor
public class GetStatisticsService {
    private final StudentsRepository studentsRepository;
    private final StudentGradesRepository studentGradesRepository;

    public List<ResponseAverageStudentGradeByClass> getAverageStudentGrade(int group) {
        List<Students> students = studentsRepository.findByGroupName(group);
        List<ResponseAverageStudentGradeByClass> responseList = new ArrayList<>();

        for (Students student : students) {
            List<StudentGrades> studentGrades = studentGradesRepository.findByStudentsGroupName(student.getId());
            double averageGrade = calculateAverageGrade(studentGrades);

            ResponseAverageStudentGradeByClass response = new ResponseAverageStudentGradeByClass(student.getName(), student.getFamily(), averageGrade);
            responseList.add(response);
        }

        return responseList;
    }

    private double calculateAverageGrade(List<StudentGrades> studentGrades) {
        double sum = 0.0;
        int count = 0;

        for (StudentGrades grade : studentGrades) {
            sum += grade.getPhysics() + grade.getMathematics() + grade.getRus() + grade.getLiterature() + grade.getGeometry() + grade.getInformatics();
            count++;
        }

        return count > 0 ? sum / (6 * count) : 0.0;
    }
}
