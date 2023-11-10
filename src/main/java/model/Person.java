package model;

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


    public int getPersonId() {
        return personId;
    }

    public String getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGroup() {
        return group;
    }

    public int getPhysics() {
        return physics;
    }

    public int getMathematics() {
        return mathematics;
    }

    public int getRus() {
        return rus;
    }

    public int getLiterature() {
        return literature;
    }

    public int getGeometry() {
        return geometry;
    }

    public int getInformatics() {
        return informatics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public void setMathematics(int mathematics) {
        this.mathematics = mathematics;
    }

    public void setRus(int rus) {
        this.rus = rus;
    }

    public void setLiterature(int literature) {
        this.literature = literature;
    }

    public void setGeometry(int geometry) {
        this.geometry = geometry;
    }

    public void setInformatics(int informatics) {
        this.informatics = informatics;
    }
}
