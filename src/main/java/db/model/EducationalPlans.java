package db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_educational_plans")
public class EducationalPlans {
    @Id
    @GeneratedValue
    private Long id;
    int group_name;
    @OneToOne
    @JoinColumn(name = "group_name")
    private Students students;
    boolean physics;
    boolean mathematics;
    boolean rus;
    boolean literature;
    boolean geometry;
    boolean informatics;

}
