package services.interfaces;

import db.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {
    @Query("""
        select new db.model.Students(
            s.id,
            s.name,
            s.family,
            s.groupName
        )
          from Students s where s.groupName = :query
    """)
    List<Students> findByGroupName(@Param("query") int group);
}
