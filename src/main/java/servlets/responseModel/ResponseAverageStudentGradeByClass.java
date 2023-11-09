package servlets.responseModel;
/*
Попытался сделать данный класс с extends Person, декларируя только поле averageGrade и используя конструктор:

public PersonAwerageGrade(String name, String family, double averageGrade) {
        super(name, family);
        this.averageGrade = averageGrade;
        }

Но почему-то в ответе стали возвращаться не только эти три поля, но и все остальные из класса Person. Побороть не смог,
поэтому сделал просто класс PersonAwerageGrade со своими полями.
        */
public class ResponseAverageStudentGradeByClass {

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    String name;
    String family;
    double averageGrade;


    public ResponseAverageStudentGradeByClass(String name, String family, double averageGrade) {
        this.name = name;
        this.family = family;
        this.averageGrade = averageGrade;
    }
}
