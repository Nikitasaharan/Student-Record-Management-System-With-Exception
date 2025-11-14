package service;

import model.Student;

public interface RecordActions {
    void addStudent(Student s);
    void deleteStudent(int rollNo);
    void updateStudent(int rollNo, Student s);
    void searchStudent(int rollNo);
    void viewAllStudents();
}
