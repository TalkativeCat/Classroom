package services.interfaces;

import db.model.StudentGrades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentGradesRepository extends JpaRepository<StudentGrades, Long> {
    List<StudentGrades> findByStudentsGroupName(int groupName);
}
