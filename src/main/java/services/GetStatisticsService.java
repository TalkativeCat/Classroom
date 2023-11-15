package services;

import db.model.StudentGrades;
import db.model.Students;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import services.interfaces.StudentGradesRepository;
import services.interfaces.StudentsRepository;
import servlets.requestModel.RequestChangeGradeForSubject;
import servlets.responseModel.ResponseAverageStudentGradeByClass;
import servlets.responseModel.ResponseChangeGradeForSubject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Validated
public class GetStatisticsService {
    private final StudentsRepository studentsRepository;
    private final StudentGradesRepository studentGradesRepository;

    public GetStatisticsService(StudentsRepository studentsRepository, StudentGradesRepository studentGradesRepository) {
        this.studentsRepository = studentsRepository;
        this.studentGradesRepository = studentGradesRepository;
    }



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



    public ResponseChangeGradeForSubject changeGrade(RequestChangeGradeForSubject requestChangeGradeForSubject) {
        int personId = requestChangeGradeForSubject.getPersonId();
        String subject = requestChangeGradeForSubject.getSubject();
        int newGrade = requestChangeGradeForSubject.getNewGrade();

        ResponseChangeGradeForSubject targetPerson = new ResponseChangeGradeForSubject();

        Optional<Students> optionalStudent = studentsRepository.findById((long) personId);
        if (optionalStudent.isPresent()) {
            Students student = optionalStudent.get();
            targetPerson.setPersonId(student.getId());

            Optional<StudentGrades> optionalGrades = studentGradesRepository.findById(student.getId());
            if (optionalGrades.isPresent()) {
                StudentGrades grades = optionalGrades.get();
                switch (subject) {
                    case "physics" -> {
                        targetPerson.setOldGrade(grades.getPhysics());
                        grades.setPhysics(newGrade);
                        targetPerson.setNewGrade(grades.getPhysics());
                    }
                    case "mathematics" -> {
                        targetPerson.setOldGrade(grades.getMathematics());
                        grades.setMathematics(newGrade);
                        targetPerson.setNewGrade(grades.getMathematics());
                    }
                    case "rus" -> {
                        targetPerson.setOldGrade(grades.getRus());
                        grades.setRus(newGrade);
                        targetPerson.setNewGrade(grades.getRus());
                    }
                    case "literature" -> {
                        targetPerson.setOldGrade(grades.getLiterature());
                        grades.setLiterature(newGrade);
                        targetPerson.setNewGrade(grades.getLiterature());
                    }
                    case "geometry" -> {
                        targetPerson.setOldGrade(grades.getGeometry());
                        grades.setGeometry(newGrade);
                        targetPerson.setNewGrade(grades.getGeometry());
                    }
                    case "informatics" -> {
                        targetPerson.setOldGrade(grades.getInformatics());
                        grades.setInformatics(newGrade);
                        targetPerson.setNewGrade(grades.getInformatics());
                    }
                }

                studentGradesRepository.save(grades);
            }
        }

        return targetPerson;
    }

}
