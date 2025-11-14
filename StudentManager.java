package service;
import exceptions.StudentNotFoundException;
import java.util.*;
import model.Student;
import threads.Loader;

public class StudentManager implements RecordActions {
    private Map<Integer, Student> map = new HashMap<>();
    public StudentManager(List<Student> students) {
        for (Student s : students) {
            map.put(s.getRollNo(), s);
        }
    }

    @Override
    public void addStudent(Student s) {
        try {
            if (map.containsKey(s.getRollNo()))
                throw new IllegalArgumentException("Duplicate roll number!");

            Thread loader = new Thread(new Loader("Adding"));
            loader.start();
            loader.join();

            map.put(s.getRollNo(), s);
            System.out.println("Student added.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteStudent(int rollNo) {
        if (map.remove(rollNo) != null)
            System.out.println("Student removed.");
        else
            System.out.println("Record not found.");
    }

    @Override
    public void updateStudent(int rollNo, Student updated) {
        if (map.containsKey(rollNo)) {
            map.put(rollNo, updated);
            System.out.println("Record updated.");
        } else {
            System.out.println("No such record exists.");
        }
    }

    @Override
    public void searchStudent(int rollNo) {
        try {
            if (!map.containsKey(rollNo))
                throw new StudentNotFoundException("Student does not exist!");

            map.get(rollNo).displayInfo();

        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void viewAllStudents() {
        for (Student s : map.values()) {
            s.displayInfo();
        }
    }

    public List<Student> sortedByMarks() {
        List<Student> list = new ArrayList<>(map.values());
        list.sort((a, b) -> Double.compare(b.getMarks(), a.getMarks()));
        return list;
    }
}
