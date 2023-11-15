CREATE TABLE t_students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    family VARCHAR(50) NOT NULL,
    age INT,
    group_name INT
);
CREATE TABLE t_student_grades (
    id SERIAL PRIMARY KEY,
    physics INT,
    mathematics INT,
    rus INT,
    literature INT,
    geometry INT,
    informatics INT
);
CREATE TABLE t_educational_plans (
    id SERIAL PRIMARY KEY,
    group_name INT,
    physics BOOLEAN,
    mathematics BOOLEAN,
    rus BOOLEAN,
    literature BOOLEAN,
    geometry BOOLEAN,
    informatics BOOLEAN
);
