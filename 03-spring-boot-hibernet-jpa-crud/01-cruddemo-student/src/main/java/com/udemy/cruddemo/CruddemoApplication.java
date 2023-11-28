package com.udemy.cruddemo;

import com.udemy.cruddemo.dao.StudentDAO;
import com.udemy.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    // CommandLine Runner for command line application
//    @Bean
//    public CommandLineRunner commandLineRunner(String[] java) {
//        return runner -> {
//            System.out.println("Hello World");
//        };
//    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO theStudentDAO) {
        return runner -> {
            // create the student
//            createStudent(theStudentDAO);

            // create multiple students
            createMultipleStudents(theStudentDAO);

            // find a student by id
//            readStudent(theStudentDAO);

            // find all students
//            queryForStudents(theStudentDAO);

            // find students by last name
//            queryForStudentsByLastName(theStudentDAO);

            // update the students
//            updateStudents(theStudentDAO);


            // delete student by id
//            deleteStudent(theStudentDAO);

            // delete all students
//          deleteAllStudents(theStudentDAO);
        };
    }

    private void createStudent(StudentDAO theStudentDAO) {

        // create the student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");

        // save the student object
        System.out.println("Saving the student...");
        theStudentDAO.save(tempStudent);

        // display the id of saved student id
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

    private void createMultipleStudents(StudentDAO theStudentDAO) {
        // create the student object
        System.out.println("Creating 3 student objects...");
        Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
        Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

        // save the student objects
        System.out.println("Saving the students...");
        theStudentDAO.save(tempStudent1);
        theStudentDAO.save(tempStudent2);
        theStudentDAO.save(tempStudent3);

    }

    private void readStudent(StudentDAO theStudentDAO) {

        // create the student --> save the student --> retrieve that saved student id --> display that student

        // create the student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

        // save the student object
        System.out.println("Saving the student...");
        theStudentDAO.save(tempStudent);

        // display the id of saved student id
        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        // retrieve student from database using id

        System.out.println("\nGetting student with id: " + theId);
        Student myStudent = theStudentDAO.findById(theId);

        // display the retrieved student
        System.out.println("Found the student: " + myStudent);
    }

    private void queryForStudents(StudentDAO theStudentDAO) {

        // get all students
        System.out.println("Getting all students...");
        List<Student> theStudents = theStudentDAO.findAll();

        // display the students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // get list of students
        List<Student> theStudents = studentDAO.findByLastName("Duck");

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void updateStudents(StudentDAO studentDAO) {

        // retrieve student based on id: primary key
        int studentId = 1001;
        System.out.println("Getting student with id: " + studentId);

        Student myStudent = studentDAO.findById(studentId);
        System.out.println("Found student: " + myStudent);
        // change first name to "Scooby"
        System.out.println("Updating student...");
//        myStudent.setFirstName("Scooby");
        myStudent.setEmail("scooby@luv2code.com");
        myStudent.setFirstName("John");
        myStudent.setEmail("john@luv2code.com");

        // update the student
        studentDAO.update(myStudent);

        // display the updated student
        System.out.println("Updated student: " + myStudent);
    }

    private void deleteStudent(StudentDAO studentDAO) {

        int studentId = 1003;

        System.out.println("Deleting student with id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void deleteAllStudents(StudentDAO studentDAO) {

        System.out.println("Deleting all students...");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Number of rows deleted: " + numRowsDeleted);
    }
}
