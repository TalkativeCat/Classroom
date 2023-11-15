package servlets.commands;


import dataLoad.Reader;
import model.Person;
import services.StudentService;
import servlets.requestModel.RequestChangeGradeForSubject;
import servlets.responseModel.ResponseChangeGradeForSubject;


public class ChangeGradeForSubject {


//    public ResponseChangeGradeForSubject changeGrade(RequestChangeGradeForSubject requestChangeGradeForSubject) {
//        int personId = requestChangeGradeForSubject.getPersonId();
//        String subject = requestChangeGradeForSubject.getSubject();
//        int newGrade = requestChangeGradeForSubject.getNewGrade();
//        Reader reader = new Reader();
//
//        ResponseChangeGradeForSubject targetPerson = new ResponseChangeGradeForSubject();
//        StudentService studentService = new StudentService(reader);
//
//
//        for (Person person : studentService.getStudents()) {
//            if (person.getPersonId() == personId) {
//                targetPerson.setPersonId(person.getPersonId());
//                switch (subject) {
//                    case "physics":
//                        targetPerson.setOldGrade(person.getPhysics());
//                        person.setPhysics(newGrade);
//                        targetPerson.setNewGrade(person.getPhysics());
//                        break;
//                    case "mathematics":
//                        targetPerson.setOldGrade(person.getMathematics());
//                        person.setMathematics(newGrade);
//                        targetPerson.setNewGrade(person.getMathematics());
//                        break;
//                    case "rus":
//                        targetPerson.setOldGrade(person.getRus());
//                        person.setRus(newGrade);
//                        targetPerson.setNewGrade(person.getRus());
//                        break;
//                    case "literature":
//                        targetPerson.setOldGrade(person.getLiterature());
//                        person.setLiterature(newGrade);
//                        targetPerson.setNewGrade(person.getLiterature());
//                        break;
//                    case "geometry":
//                        targetPerson.setOldGrade(person.getGeometry());
//                        person.setGeometry(newGrade);
//                        targetPerson.setNewGrade(person.getGeometry());
//                        break;
//                    case "informatics":
//                        targetPerson.setOldGrade(person.getInformatics());
//                        person.setInformatics(newGrade);
//                        targetPerson.setNewGrade(person.getInformatics());
//                        break;
//                }
//            }
//        }
//
//        return targetPerson;
//    }
}
