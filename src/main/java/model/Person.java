package model;

import lombok.Data;

@Data
public class Person {
    int personId;
    String family;
    String name;
    int age;
    int group;
    int physics;
    int mathematics;
    int rus;
    int literature;
    int geometry;
    int informatics;

    public Person(int personId, String family, String name, int age, int group, int physics, int mathematics, int rus, int literature, int geometry, int informatics) {
        this.personId = personId;
        this.family = family;
        this.name = name;
        this.age = age;
        this.group = group;
        this.physics = physics;
        this.mathematics = mathematics;
        this.rus = rus;
        this.literature = literature;
        this.geometry = geometry;
        this.informatics = informatics;
    }

}
