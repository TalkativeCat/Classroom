package services.interfaces;

import db.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {
    List<Students> findByGroupName(int groupName);
}
