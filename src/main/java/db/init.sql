CREATE TABLE students (
    person_id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    family VARCHAR(50) NOT NULL,
    age INT,
    group_name INT
);
CREATE TABLE student_grades (
    person_id INT PRIMARY KEY,
    physics INT,
    mathematics INT,
    rus INT,
    literature INT,
    geometry INT,
    informatics INT
);
CREATE TABLE student_grades (
    group_name INT PRIMARY KEY,
    physics INT,
    mathematics INT,
    rus INT,
    literature INT,
    geometry INT,
    informatics INT
);
