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
    @Column(name = "group_name")
    int groupName;

    @OneToOne(mappedBy = "id")
    private StudentGrades studentGrades;

    @OneToOne(mappedBy = "group_name")
    private EducationalPlans educationalPlans;

    public Students(Long id, String name, String family, int groupName) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.groupName = groupName;
    }

    public Students() {

    }
}
