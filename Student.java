package model;
public class Student extends Person {

    private int rollNo;
    private String course;
    private double marks;
    private String grade;

    public Student(int rollNo, String name, String email, String course, double marks) {
        super(name, email);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        this.grade = calculateGrade();
    }

    public int getRollNo() { return rollNo; }
    public double getMarks() { return marks; }

    public String calculateGrade() {
        if (marks >= 90) return "A";
        if (marks >= 80) return "B";
        if (marks >= 70) return "C";
        return "D";
    }

    @Override
    public void displayInfo() {
        System.out.println("\nStudent Info:");
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }

    @Override
    public String toString() {
        return rollNo + "," + name + "," + email + "," + course + "," + marks;
    }
}
