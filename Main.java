import java.util.*;
import model.Student;
import service.StudentManager;
import util.FileService;

public class Main {
    public static void main(String[] args) {

        List<Student> loaded = FileService.load("students.txt");
        StudentManager sm = new StudentManager(loaded);

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Student Record Management System =====");

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Roll No");
            System.out.println("4. Delete by Roll No");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Save & Exit");
            System.out.print("Enter choice: ");

            int ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1:
                    System.out.print("Roll No: ");
                    int roll = Integer.parseInt(sc.nextLine());

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    System.out.print("Marks: ");
                    double marks = Double.parseDouble(sc.nextLine());

                    sm.addStudent(new Student(roll, name, email, course, marks));
                    break;

                case 2:
                    sm.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Roll No: ");
                    sm.searchStudent(Integer.parseInt(sc.nextLine()));
                    break;

                case 4:
                    System.out.print("Enter Roll No: ");
                    sm.deleteStudent(Integer.parseInt(sc.nextLine()));
                    break;

                case 5:
                    System.out.println("Sorted by Marks:");
                    for (Student s : sm.sortedByMarks())
                        s.displayInfo();
                    break;

                case 6:
                    FileService.save("students.txt", new ArrayList<>(loaded));
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}