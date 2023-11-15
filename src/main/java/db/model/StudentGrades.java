package db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_student_grades")
public class StudentGrades {
    @Id
    @GeneratedValue
    private Long id;
    int physics;
    int mathematics;
    int rus;
    int literature;
    int geometry;
    int informatics;

    @OneToOne
    @JoinColumn(name = "id")
    private Students students;


}
