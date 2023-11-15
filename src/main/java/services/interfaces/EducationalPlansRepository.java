package services.interfaces;

import db.model.EducationalPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationalPlansRepository extends JpaRepository<EducationalPlans, Long> {
    List<EducationalPlans> findByGroupName(int groupName);
}
