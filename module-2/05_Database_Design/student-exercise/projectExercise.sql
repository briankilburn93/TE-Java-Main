DROP DATABASE IF EXISTS projectExercise;

CREATE DATABASE projectExercise;

-- Create table

CREATE TABLE department (
        department_id          SERIAL PRIMARY KEY,
        name                   VARCHAR(100) NOT NULL,
        number_of_employees    INTEGER
);

CREATE TABLE Employee (
        employee_id        SERIAL PRIMARY KEY,
        job_title          VARCHAR(100) NOT NULL,
        last_name          VARCHAR(30) NOT NULL,
        first_name         VARCHAR(20) NOT NULL,
        gender             VARCHAR(10),
        date_of_birth      DATE,
        date_of_hire       DATE,
        department_id      INTEGER NOT NULL,
        CONSTRAINT fk_employee_department FOREIGN KEY (department_id) REFERENCES department (department_id)
);

CREATE TABLE project (
        project_id       SERIAL PRIMARY KEY,
        name              VARCHAR(100),
        start_date        DATE,
        number_of_employees INTEGER
);

CREATE TABLE employee_project (
        employee_id            INTEGER NOT NULL,
        project_id          INTEGER NOT NULL,
        CONSTRAINT pk_employee_project_employee_id_project_id PRIMARY KEY(employee_id, project_id),
        CONSTRAINT fk_employee_project_employee_id FOREIGN KEY(employee_id) REFERENCES employee (employee_id),
        CONSTRAINT fk_employee_project_project_id FOREIGN KEY(project_id) REFERENCES project (project_id)
);

--populate 4 projects
--START TRANSACTION
INSERT INTO project (project_id, name, start_date, number_of_employees) VALUES (1, 'Ironman', '10/10/2019', 1);
INSERT INTO project (project_id, name, start_date, number_of_employees) VALUES (2, 'Hulk', '09/05/2017', 1);
INSERT INTO project (project_id, name, start_date, number_of_employees) VALUES (3, 'Captain', '12/12/2015', 1);
INSERT INTO project (project_id, name, start_date, number_of_employees) VALUES (4, 'Gambit', '01/21/2011', 1);
--ROLLBACK
--COMMIT
--populate 3 departments
--START TRANSACTION
INSERT INTO department (department_id, name, number_of_employees) VALUES (1, 'Avengers', 2);
INSERT INTO department (department_id, name, number_of_employees) VALUES (2, 'Marvel', 2);
INSERT INTO department (department_id, name, number_of_employees) VALUES (3, 'XMen', 4);
--ROLLBACK
--COMMIT
--populate 8 employees
--START TRANSACTION
INSERT INTO employee(employee_id, job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_id)
VALUES (1, 'tank', 'reinhardt', 'hero', 'male', '01/10/1990', '10/20/2012', 1);
INSERT INTO employee(employee_id, job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_id)
VALUES (2, 'tank', 'orisa', 'hero', 'female', '01/18/1960', '10/20/2012', 1);
INSERT INTO employee(employee_id, job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_id)
VALUES (3, 'dps', 'ashe', 'hero', 'female', '11/15/1988', '05/10/2016', 2);
INSERT INTO employee(employee_id, job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_id)
VALUES (4, 'dps', 'genji', 'hero', 'male', '11/15/1978', '05/10/2016', 2);
INSERT INTO employee(employee_id, job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_id)
VALUES (5, 'support', 'mercy', 'hero', 'female', '11/15/1988', '05/10/2016', 3);
INSERT INTO employee(employee_id, job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_id)
VALUES (6, 'support', 'lucio', 'hero', 'male', '10/13/1998', '05/10/2016', 3);
INSERT INTO employee(employee_id, job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_id)
VALUES (7, 'support', 'moira', 'hero', 'female', '11/15/1988', '05/10/2016', 3);
INSERT INTO employee(employee_id, job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_id)
VALUES (8, 'support', 'zenyatta', 'hero', 'male', '11/15/1988', '05/10/2016', 3);
--ROLLBACK
--COMMIT
0--each project has 1 employee assigned
--START TRANSACTION
INSERT INTO employee_project(employee_id, project_id) VALUES (1, 1);
INSERT INTO employee_project(employee_id, project_id) VALUES (2, 2);
INSERT INTO employee_project(employee_id, project_id) VALUES (3, 3);
INSERT INTO employee_project(employee_id, project_id) VALUES (4, 4);
--ROLLBACK
--COMMIT

