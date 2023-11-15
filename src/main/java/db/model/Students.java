package db.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    String name;
    @NotNull
    String family;
    int age;
    int group_name;

    @OneToOne(mappedBy = "students")
    private StudentGrades studentGrades;

    @OneToOne(mappedBy = "students")
    private EducationalPlans educationalPlans;


}
