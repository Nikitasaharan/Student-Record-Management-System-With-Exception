package util;
import java.io.*;
import java.util.*;
import model.Student;

public class FileService {
    public static List<Student> load(String file) {
        List<Student> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String data;

            while ((data = br.readLine()) != null) {
                String[] arr = data.split(",");

                int roll = Integer.parseInt(arr[0]);
                String name = arr[1];
                String email = arr[2];
                String course = arr[3];
                double marks = Double.parseDouble(arr[4]);

                list.add(new Student(roll, name, email, course, marks));
            }
        } catch (Exception e) {
            System.out.println("Could not load existing records.");
        }

        return list;
    }
    public static void save(String file, List<Student> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Student s : list) {
                bw.write(s.toString());
                bw.newLine();
            }
            System.out.println("Records saved.");
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }
}
