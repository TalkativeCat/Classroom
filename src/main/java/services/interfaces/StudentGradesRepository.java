package services.interfaces;

import db.model.StudentGrades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentGradesRepository extends JpaRepository<StudentGrades, Long> {
    @Query("""
        select new db.model.StudentGrades(
            s.physics,
            s.mathematics,
            s.rus,
            s.literature,
            s.geometry,
            s.informatics
        )
          from StudentGrades s where s.id = :query
    """)
    List<StudentGrades> findByStudentsGroupName(@Param("query") long id);
}
